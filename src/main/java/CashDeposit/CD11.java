package CashDeposit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CD11 {
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
        System.out.println("Balance before cash deposit is:  " + balanceBefore);
        WebElement cashDeposit = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[3]"));
        cashDeposit.click();

        WebElement accountNumber = fdriver.findElement(By.id("productName"));
        WebElement sortCode = fdriver.findElement(By.id("productDescription"));
        WebElement amount = fdriver.findElement(By.id("productPrice"));
        accountNumber.sendKeys("20912429"); // Valid Account Number
        sortCode.sendKeys("12341234");       // invalid Sort Code
        amount.sendKeys("600");            // Valid Amount
        Thread.sleep(1500);

        WebElement depositButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/form/button"));
        depositButton.click();
        Thread.sleep(1500);
        WebElement balance2 = fdriver.findElement(By.cssSelector(".main-content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > p:nth-child(4)"));
        String balanceAfter = balance2.getText();
        System.out.println("Balance after cash deposit is: " + balanceAfter);
        Thread.sleep(2000);

        try {
            if (balanceBefore.equals(balanceAfter)) {
                System.out.println("Balance of the account is the same now as it was on the beginning of this code");
                System.out.println("Test Successful");
            } else {
                System.out.println("Cash deposit worked with wrong sort-code, balance differs from what it was on the beginning");
                System.out.println("Test Failed");
            }
        } finally {
            fdriver.quit();
        }
    }
}