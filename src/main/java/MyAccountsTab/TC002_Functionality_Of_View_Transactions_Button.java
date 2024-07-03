package MyAccountsTab;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC002_Functionality_Of_View_Transactions_Button {
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

        try {
            WebElement myAccounts = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[2]"));
            myAccounts.click();
            Thread.sleep(1000);
            WebElement viewTransactions = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div/div[1]/div[2]/button[1]"));
            viewTransactions.click();
            if (fdriver.getCurrentUrl().equals("http://lsetbank.lset.uk/myaccounts/transactions")) {
                System.out.println("View Transactions Tab works");
                System.out.println("Test Successful");
            } else {
                System.out.println(fdriver.getCurrentUrl());
                System.out.println("My accounts Tab doesn't work");
                System.out.println("Test Failed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Test Failed -  No Element found");
        } finally {
            fdriver.quit();
        }


    }
}