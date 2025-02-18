package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Setup {

    public static WebDriver driver;

    public static void setUpBrowser(String browser)
    {
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
            System.out.println("Chrome started");
        } else if (browser.equals("Edge")){
            driver = new EdgeDriver();
            System.out.println("Edge started");
        } else {
            driver = new FirefoxDriver();
            System.out.println("Firefox started");
        }
        driver.manage().window().maximize();
    }

    public void navigateToURL(String url){
        driver.navigate().to(url);
    }

    public void tearDown(){
        driver.quit();
    }
}
