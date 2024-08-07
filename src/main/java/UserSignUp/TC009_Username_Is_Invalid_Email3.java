package UserSignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC009_Username_Is_Invalid_Email3 {
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

        usernameField.sendKeys("@example.com");
        passwordField.sendKeys("156;TyPass");
        confirmPasswordField.sendKeys("156;TyPass");
        emailField.sendKeys("@example.com");
        signUpButton2.click();
        Thread.sleep(1000);

        try {
            WebElement errorPopUp = fdriver.findElement(By.xpath("/html/body/div/main/div/form/div[4]/div"));
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
