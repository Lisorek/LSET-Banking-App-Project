package UserSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SI6 {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver = new FirefoxDriver();
        fdriver.get("http://lsetbank.lset.uk/");
        fdriver.manage().window().maximize();

        WebElement loginButton = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
        loginButton.click();

        WebElement username = fdriver.findElement(By.id("username"));
        WebElement password = fdriver.findElement(By.id("password"));
        username.sendKeys("fipepok686@etopys.com");
        password.sendKeys("Invalid123");

        WebElement errorPopUp = fdriver.findElement(By.className("Toastify"));
        WebElement signInButton = fdriver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));

        for (int i = 0; i <10; i++){
            signInButton.click();
            Thread.sleep(2500);
            System.out.println(errorPopUp.getText());
            Thread.sleep(2500);
        }
        String title = fdriver.getCurrentUrl();
        System.out.println("User got to URL:  " + title + " So the test was:");
        fdriver.close();
        if (title.equals("http://lsetbank.lset.uk/")) {
            System.out.println("Test Successful");
        } else {
            System.out.println("Test failed");
        }
    }
}

