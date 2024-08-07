package UserSignUp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC022_Password_Button_Works_On_All_Browsers {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver fdriver = new FirefoxDriver();
        ChromeDriver chdriver = new ChromeDriver();
        EdgeDriver edriver = new EdgeDriver();
        try {
            fdriver.get("http://lsetbank.lset.uk/");
            fdriver.manage().window().maximize();
            System.out.println("Firefox - The page loaded with this title: " + fdriver.getTitle());

            chdriver.get("http://lsetbank.lset.uk/");
            chdriver.manage().window().maximize();
            System.out.println("Chrome - The page loaded with this title: " + chdriver.getTitle());

            edriver.get("http://lsetbank.lset.uk/");
            edriver.manage().window().maximize();
            System.out.println("Edge - The page loaded with this title: " + edriver.getTitle());
        }
        finally {
            fdriver.quit();
            chdriver.quit();
            edriver.quit();
        }
        }
    }
