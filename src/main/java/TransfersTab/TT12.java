package TransfersTab;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TT12 {
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

        WebElement myAccounts = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[2]"));
        myAccounts.click();
        Thread.sleep(1500);
        WebElement transferButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div/div[1]/div[2]/button[2]"));
        transferButton.click();

        WebElement accountNumber = fdriver.findElement(By.id("productName"));
        //WebElement sortCode = fdriver.findElement(By.id("productDescription"));
        WebElement amountField = fdriver.findElement(By.id("productPrice"));
        WebElement submitButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/form/button"));
        accountNumber.sendKeys("57642188");
        //sortCode.sendKeys("");
        amountField.sendKeys("1");
        submitButton.click();

        try {
            WebElement errorPopUp = fdriver.findElement(By.xpath("/html/body/div/main/div/div/form/div[2]/div"));
            if (errorPopUp.getText().equals("")) {
                System.out.println("There's no error displayed");
                System.out.println("Test Failed");
            } else {
            System.out.println("After providing no sort code, Error displayed under it says: " + errorPopUp.getText());
            System.out.println("Test Successful");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No error pop-up appeared.");
            System.out.println("Test Failed");
        } finally {
            fdriver.quit();
        }
    }
}
