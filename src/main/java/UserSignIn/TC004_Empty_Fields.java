package UserSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC004_Empty_Fields {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver = new FirefoxDriver();
        fdriver.get("http://lsetbank.lset.uk/");
        fdriver.manage().window().maximize();

        WebElement loginButton = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
        loginButton.click();

        WebElement username = fdriver.findElement(By.id("username"));
        WebElement password = fdriver.findElement(By.id("password"));

        WebElement signInButton = fdriver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));
        signInButton.click();
        Thread.sleep(2000);
        String title = fdriver.getCurrentUrl();
        System.out.println("User got to URL:  " + title + " So the test was:");
        if(title.equals("http://lsetbank.lset.uk/signin")) {
            System.out.println("Test Successful");
        }
        else {
            System.out.println("Test failed");
        }
        fdriver.quit();
    }
}