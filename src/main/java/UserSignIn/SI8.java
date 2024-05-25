package UserSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SI8 {
    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver for Firefox

        WebDriver driver = new FirefoxDriver();

        try {
            // URL of the login page
            String url = "http://lsetbank.lset.uk/";

            // Open the login page
            driver.get(url);
            driver.manage().window().maximize();

            // Wait until the login button is clickable and click it
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/nav/div/div/button[1]")));
            loginButton.click();

            // Wait until username and password fields are visible
            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

            // Check if the fields are pre-filled by the browser's auto-fill feature
            String autofilledUsername = usernameInput.getAttribute("value");
            String autofilledPassword = passwordInput.getAttribute("value");

            if (autofilledUsername.equals("fipepok686@etopys.com") && autofilledPassword.equals("Password123!")) {
                System.out.println("Auto-fill successful: Username and Password are pre-filled.");

                // Click the sign-in button
                WebElement signInButton = driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button"));
                signInButton.click();

                // Wait for the page to load
                Thread.sleep(2500);

                // Get and print the current URL
                String title = driver.getCurrentUrl();
                System.out.println("User got to URL: " + title + " So the test was:");

                // Verify if the login was successful
                if (!title.equals("http://lsetbank.lset.uk/")) {
                    System.out.println("Test Successful: User logged in with auto-filled credentials.");
                } else {
                    System.out.println("Test Failed: User did not log in successfully.");
                }
            } else {
                System.out.println("Test Failed: Username and/or Password are not pre-filled.");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}