package UserSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SI7 {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver managers

        // Define login credentials and URL
        String url = "http://lsetbank.lset.uk/";
        String username = "fipepok686@etopys.com";
        String password = "Password123!";

        // Create two threads for simultaneous logins
        Thread thread1 = new Thread(() -> performLoginWithFirefox(url, username, password));
        Thread thread2 = new Thread(() -> performLoginWithChrome(url, username, password));

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }

    public static void performLoginWithFirefox(String url, String username, String password) {
        // Initialize Firefox WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Perform login
            performLogin(driver, url, username, password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void performLoginWithChrome(String url, String username, String password) {
        // Initialize Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Perform login
            performLogin(driver, url, username, password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void performLogin(WebDriver driver, String url, String username, String password) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/nav/div/div/button[1]"));
        loginButton.click();

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));
        signInButton.click();
        Thread.sleep(2500);
        String title = driver.getCurrentUrl();
        System.out.println("User got to URL:  " + title + " So the test was:");
        if (title.equals("http://lsetbank.lset.uk/")) {
            System.out.println("Test Successful");
        } else {
            System.out.println("Test failed");
        }
    }
}