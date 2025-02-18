package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    public WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class = 'brandLoader']")
    public WebElement loader;

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(90));

    public void waitToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitToBeInvisible(WebElement element){

        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitToBeClickable(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clearText(WebElement element){
        element.clear();
    }

    public void pressEnterBTN(WebElement element){
        element.sendKeys(Keys.ENTER);
    }

    public void clickOnElement(WebElement element){
        waitToBeClickable(element);
        element.click();
    }

}
