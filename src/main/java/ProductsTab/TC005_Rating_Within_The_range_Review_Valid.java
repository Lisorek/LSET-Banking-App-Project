package ProductsTab;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC005_Rating_Within_The_range_Review_Valid {
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
        rating.sendKeys("4");
        review.sendKeys("Good product!");
        Thread.sleep(2500);
        WebElement submit = fdriver.findElement(By.xpath("/html/body/div/main/div/div[2]/div/form/button"));
        submit.click();
        Thread.sleep(1000);

        try {
            WebElement errorPopUp = fdriver.findElement(By.className("Toastify"));
            if (errorPopUp.getText().equals("")) {
                System.out.println("There's no error displayed");
                System.out.println("Test Failed");
            } else {
                System.out.println("After providing valid data, Error displayed under it says: " + errorPopUp.getText());
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
