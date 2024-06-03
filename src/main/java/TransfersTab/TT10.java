package TransfersTab;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TT10 {
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
        WebElement balance = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div/div[1]/div[1]/p[3]"));
        String balanceBefore = balance.getText();
        System.out.println("Balance before transfer is:  " + balanceBefore);
        Thread.sleep(1000);
        WebElement transferButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div/div[1]/div[2]/button[2]"));
        transferButton.click();

        WebElement accountNumber = fdriver.findElement(By.id("productName"));
        WebElement sortCode = fdriver.findElement(By.id("productDescription"));
        WebElement amountField = fdriver.findElement(By.id("productPrice"));
        WebElement submitButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/form/button"));
        accountNumber.sendKeys("57642188");
        sortCode.sendKeys("1234");
        amountField.sendKeys("1");
        submitButton.click();
        Thread.sleep(1500);
        WebElement balance2 = fdriver.findElement(By.cssSelector(".main-content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > p:nth-child(4)"));
        String balanceAfter = balance2.getText();
        System.out.println("Balance after transfer is: " + balanceAfter);
        if (balanceBefore.equals(balanceAfter)) {
            System.out.println("Balance is the same so the transfer didn't work");
        } else {
            System.out.println("Balance differs, unfortunately wrong transfer worked and sent the money");
        }

        try {
            WebElement errorPopUp = fdriver.findElement(By.className("Toastify"));
            if (errorPopUp.getText().equals("")) {
                System.out.println("There's no error displayed");
                System.out.println("Test Failed");
            } else {
            System.out.println("After wrong sort code (4 digits), Error displayed under it says: " + errorPopUp.getText());
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
