package UserSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SI7 {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver1 = new FirefoxDriver();
        FirefoxDriver fdriver2 = new FirefoxDriver();

        try {
            String url = "http://lsetbank.lset.uk/";

            fdriver1.get(url);
            fdriver1.manage().window().maximize();
            fdriver2.get(url);
            fdriver2.manage().window().maximize();

            //first browser
            WebElement loginButton1 = fdriver1.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
            loginButton1.click();
            WebElement username1 = fdriver1.findElement(By.id("username"));
            WebElement password1 = fdriver1.findElement(By.id("password"));
            username1.sendKeys("fipepok686@etopys.com");
            password1.sendKeys("Password123!");
            WebElement signInButton1 = fdriver1.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));
            signInButton1.click();

            //second browser
            WebElement loginButton2 = fdriver2.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
            loginButton2.click();
            WebElement username2 = fdriver2.findElement(By.id("username"));
            WebElement password2 = fdriver2.findElement(By.id("password"));
            username2.sendKeys("fipepok686@etopys.com");
            password2.sendKeys("Password123!");
            WebElement signInButton2 = fdriver2.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));
            signInButton2.click();

            //time for pages to load
            Thread.sleep(5000);

            String title1 = fdriver1.getCurrentUrl();
            String title2 = fdriver2.getCurrentUrl();

            System.out.println("User got to URL in first browser: " + title1);
            System.out.println("User got to URL in second browser: " + title2);

            if (title1.equals("http://lsetbank.lset.uk/") || title2.equals("http://lsetbank.lset.uk/")) {
                System.out.println("Test Failed: Simultaneous logins are allowed.");
            } else {
                System.out.println("Test Successful: Simultaneous logins are not allowed.");
            }
        } finally {

            fdriver1.quit();
            fdriver2.quit();
        }
    }
}