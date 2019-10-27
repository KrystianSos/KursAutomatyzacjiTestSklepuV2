package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait defaultWait;
    private Actions actionDriver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        defaultWait = new WebDriverWait(driver, 10);
        actionDriver = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getDefaultWait() {
        return defaultWait;
    }

    protected Actions getActionDriver() {
        return actionDriver;
    }

    protected void click(WebElement element) {
        System.out.println("Klikam w element + " + element.getText());
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        System.out.println("Wpisuję: " + text);
        element.sendKeys(text);
    }

    protected void elementToBeClickable(WebElement element) {
        defaultWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement elementToBeClickable(By by) {
        return defaultWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void visibilityOf(WebElement element) {
        defaultWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement visibilityOf(By by) {
        return defaultWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void hoverOverElement(WebElement element) {
        actionDriver.moveToElement(element).perform();
    }

    protected WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() - 1);
        return elements.get(randomNumber);
    }

    protected boolean isPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
