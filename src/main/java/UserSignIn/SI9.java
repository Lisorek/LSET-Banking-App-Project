package UserSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class SI9 {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver = new FirefoxDriver();

            String url = "http://lsetbank.lset.uk/";

            fdriver.get(url);
            fdriver.manage().window().maximize();

            WebElement loginButton = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
            loginButton.click();

            Thread.sleep(2000);

            WebElement username = fdriver.findElement(By.id("username"));
            WebElement password = fdriver.findElement(By.id("password"));

            // Attempt to copy-paste into the username field
            String copyText = "testcopy";
            String copyText2 = "testcopy2";
            username.sendKeys(copyText);
            username.sendKeys(Keys.CONTROL + "a");
            username.sendKeys(Keys.CONTROL + "c");
            username.clear();
            username.sendKeys(Keys.CONTROL + "v");

            String usernameFieldValue = username.getAttribute("value");
            if (usernameFieldValue.equals(copyText)) {
                System.out.println("Copy-paste is allowed in the username field.");
            } else {
                System.out.println("Copy-paste is disabled in the username field.");
            }

            password.sendKeys(copyText2);
            password.sendKeys(Keys.CONTROL + "a");
            password.sendKeys(Keys.CONTROL + "c");
            password.clear();
            password.sendKeys(Keys.CONTROL + "v");

            String passwordFieldValue = password.getAttribute("value");
            if (passwordFieldValue.equals(copyText2)) {
                System.out.println("Test Failed: Copy-paste is allowed in the password field.");
            } else {
                System.out.println("Test Successful: Copy-paste is disabled in the password field.");
            }
            fdriver.quit();
        }
    }
