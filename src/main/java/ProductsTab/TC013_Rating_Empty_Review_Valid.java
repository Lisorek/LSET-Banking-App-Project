package ProductsTab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC013_Rating_Empty_Review_Valid {
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
        Thread.sleep(1500);
        fdriver.navigate().refresh();
        Thread.sleep(2000);

        WebElement productsTab = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
        productsTab.click();
        Thread.sleep(1000);
        WebElement rateButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div/div[1]/div/div[2]/button[1]"));
        rateButton.click();
        WebElement rating = fdriver.findElement(By.id("rating"));
        WebElement review = fdriver.findElement(By.id("content"));
        rating.clear();
        rating.sendKeys("");
        review.sendKeys("Such a good product!");
        Thread.sleep(2500);

        try {
        JavascriptExecutor js = (JavascriptExecutor) fdriver;
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", rating);
        System.out.println("Validation message: " + validationMessage);

        if (validationMessage != null && !validationMessage.isEmpty()) {
            System.out.println("Test successful - error appeared");
        } else {
            System.out.println("Test failed - no error");
        }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            fdriver.quit();
        }
    }
}

