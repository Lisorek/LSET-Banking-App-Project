package UserSignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC030_Email_With_Dots {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver = new FirefoxDriver();
        fdriver.get("http://lsetbank.lset.uk/");
        fdriver.manage().window().maximize();


        WebElement signUpBttn = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[2]"));
        signUpBttn.click();
        Thread.sleep(1500);

        WebElement usernameField = fdriver.findElement(By.id("username"));
        WebElement passwordField = fdriver.findElement(By.id("password"));
        WebElement confirmPasswordField = fdriver.findElement(By.id("confirmPassword"));
        WebElement emailField = fdriver.findElement(By.id("email"));
        WebElement signUpButton2 = fdriver.findElement(By.xpath("/html/body/div/main/div/form/div[5]/button"));

        usernameField.sendKeys("user.name@example.com");
        passwordField.sendKeys("Password123");
        confirmPasswordField.sendKeys("Password123");
        emailField.sendKeys("user.name@example.com");
        signUpButton2.click();
        Thread.sleep(1000);


        try {
            WebElement errorPopUp = fdriver.findElement(By.className("Toastify"));
            System.out.println("After providing all that data, Error displayed says: " + errorPopUp.getText());
            System.out.println("Test Successful");
        } catch (NoSuchElementException e) {
            System.out.println("No error pop-up appeared.");
            System.out.println("Test Failed");
        } finally {
            fdriver.quit();
        }
    }
}
