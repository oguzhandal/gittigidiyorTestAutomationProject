package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;

    public BasePage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void hoverClick(By locator) {
        this.action = new Actions(driver);
        action.moveToElement(driver.findElement(locator)).click().build().perform();
        driver.findElement(locator).click();
    }

    public String getText(By elementLocation) {
        String text = this.driver.findElement(elementLocation).getText();
        return text;
    }

    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public void verifyFullyLoaded(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ready = (String) js.executeScript("return document.readyState");
        equals("complete");
        System.out.println("Ready or not : " + ready);
    }

    public void scroll(By elementLocation) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementLocation));
        try {
            driver.findElement(elementLocation).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(elementLocation));
        }
    }

    public void randomSelection(By elementLocation) {

        List<WebElement> elements = driver.findElements(elementLocation);
        int maxCount = elements.size();
        Random random = new Random();
        int randomCount = random.nextInt(maxCount);
        elements.get(randomCount).click();

    }
}
