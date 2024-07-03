package UserSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TC006_Account_Lockout {
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

        System.out.println("Now I'm going to try to lock the account with 10 incorrect logins and the 11th try will be correct");
        for (int i = 0; i <10; i++){
            signInButton.click();
            Thread.sleep(2500);
            System.out.println(errorPopUp.getText());
            Thread.sleep(1500);
        }
        Thread.sleep(2500);
        username.clear();
        password.clear();
        username.sendKeys("fipepok686@etopys.com");
        password.sendKeys("Password123!");
        signInButton.click();
        Thread.sleep(2000);
        String title = fdriver.getCurrentUrl();
        System.out.println("User got to URL:  " + title + " So the test was:");
        if (title.equals("http://lsetbank.lset.uk/")) {
            System.out.println("Test Successful");
        } else {
            System.out.println("Test failed");
        }
        fdriver.quit();
    }
}

