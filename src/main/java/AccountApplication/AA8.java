package AccountApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AA8 {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver = new FirefoxDriver();
        fdriver.get("http://lsetbank.lset.uk/");
        fdriver.manage().window().maximize();

        WebElement loginButton = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
        loginButton.click();

        WebElement username = fdriver.findElement(By.id("username"));
        WebElement password = fdriver.findElement(By.id("password"));
        username.sendKeys("jopon90347@huleos.com");
        password.sendKeys("Password123!");

        WebElement signInButton = fdriver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));
        signInButton.click();
        Thread.sleep(2000);
        fdriver.navigate().refresh();
        Thread.sleep(2000);

        WebElement productsButton = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
        productsButton.click();
        WebElement detailButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div/div[1]/div/div[2]/button[2]"));
        detailButton.click();
        WebElement applyButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div/div[3]/button"));
        applyButton.click();
        Thread.sleep(1500);

        WebElement annualIncome = fdriver.findElement(By.id("productName"));
        WebElement monthlyExpenses = fdriver.findElement(By.id("productDescription"));
        WebElement ninoNumber = fdriver.findElement(By.id("productPrice"));
        WebElement submitButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/form/button"));
        annualIncome.sendKeys("20000");
        monthlyExpenses.sendKeys("1000");
        ninoNumber.sendKeys("£$%^&!");
        submitButton.click();
        Thread.sleep(2500);

        try {
            WebElement errorPopUp = fdriver.findElement(By.xpath("html/body/div/main/div/div/form/div[3]/div"));
            if (errorPopUp.isDisplayed()) {
                System.out.println("After providing all that data, Error displayed says: " + errorPopUp.getText());
                System.out.println("Test Successful");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No error pop-up appeared. Nino shouldn't contain special characters");
            System.out.println("Test Failed");
        } finally {
            fdriver.quit();
        }
    }
}