package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public static String homePageUrl = "https://www.gittigidiyor.com";
    By firstLoginButtonPageXpath = By.xpath("//*[contains(text(),'Giriş Yap')]");
    By loginButtonXpath = By.xpath("//a[@class='qjixn8-0 sc-1bydi5r-0 lghPw']");
    By acceptCookiesXpath = By.className("tyj39b-5");

    BasePage basePage = new BasePage(driver, wait, action);

    public HomePage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    public void goToHomePageUrl() {
        driver.get(homePageUrl);
    }

    public void verifyPageLoaded() {
        basePage.verifyFullyLoaded(driver);
    }

    public void hoverClickButton() {
        basePage.hoverClick(firstLoginButtonPageXpath);
    }

    public void clickLogin() {
        basePage.click(loginButtonXpath);
    }

    public void acceptCookies() {
        click(acceptCookiesXpath);
    }
}
