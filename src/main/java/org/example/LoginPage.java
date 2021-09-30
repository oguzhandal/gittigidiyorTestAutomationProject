package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    BasePage basePage = new BasePage(driver, wait, action);

    By mailId = By.id("L-UserNameField");
    By passwordId = By.id("L-PasswordField");
    By loginButtonXpath = By.xpath("//input[@title='Giriş Yap']");

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    public void clickLogin() {
        click(loginButtonXpath);
    }

    public void sendKeys() {
        basePage.writeText((mailId), "Please enter your account information in this field");
        basePage.writeText((passwordId), "Please enter your own account password into this field.");
    }


}
