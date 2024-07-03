package CashDeposit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC007_Enter_Empty_Fields {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver = new FirefoxDriver();
        fdriver.get("http://lsetbank.lset.uk/");
        fdriver.manage().window().maximize();

        WebElement loginButton = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
        loginButton.click();

        WebElement username = fdriver.findElement(By.id("username"));
        WebElement password = fdriver.findElement(By.id("password"));
        username.sendKeys("fipepok686@etopys.com");
        password.sendKeys("Password123!");

        WebElement signInButton = fdriver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));
        signInButton.click();
        Thread.sleep(2500);
        fdriver.navigate().refresh();
        Thread.sleep(2000);

        WebElement cashDeposit = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[3]"));
        cashDeposit.click();
        WebElement depositButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/form/button"));
        depositButton.click();
        try {
            WebElement errorPopUp = fdriver.findElement(By.className("invalid-feedback"));
            if (errorPopUp.isDisplayed()) {
                System.out.println("After providing no data, Error displayed says: " + errorPopUp.getText());
                System.out.println("Test Successful");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No error pop-up appeared. All the fields were empty");
            System.out.println("Test Failed");
        } finally {
            fdriver.quit();
        }
    }
}

