package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchListPage extends BasePage {
    String value = "Bilgisayar";
    By searchBoxName = By.name("k");
    By searchButtonXpath = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 gaMakD']/span");
    By secondPageXpath = By.xpath("//a[@class='sc-12aj18f-0 ZxdVY']/span");

    BasePage basePage = new BasePage(driver, wait, action);

    public SearchListPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    public void sendKeys() {
        basePage.writeText(searchBoxName, value);
    }

    public void searchButtonClick() {
        basePage.click(searchButtonXpath);
    }

    public void secondPageClick() {
        basePage.scroll(secondPageXpath);
    }

    public String secondPageVerify() {
        return basePage.getText(secondPageXpath);
    }
}
