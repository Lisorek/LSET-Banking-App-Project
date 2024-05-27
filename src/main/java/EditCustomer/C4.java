package EditCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class C4 {
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
        Thread.sleep(2000);
        fdriver.navigate().refresh();
        Thread.sleep(2000);
        WebElement dropDownButton = fdriver.findElement(By.id("dropdown-basic"));
        dropDownButton.click();
        WebElement changePasswordButton = fdriver.findElement(By.xpath("/html/body/div/nav/div/div/div/div/a[2]"));
        changePasswordButton.click();
        Thread.sleep(2000);

        WebElement oldPassword = fdriver.findElement(By.id("oldPassword"));
        WebElement newPassword = fdriver.findElement(By.id("newPassword"));
        WebElement passwordButton = fdriver.findElement(By.xpath("/html/body/div/main/div/div/form/div[4]/button"));
        oldPassword.sendKeys("Tomato123");
        passwordButton.click();
        Thread.sleep(2000);
        WebElement errorPopUp = fdriver.findElement(By.xpath("/html/body/div/main/div/div/div"));
        System.out.println(errorPopUp.getText());
        fdriver.close();
    }
}