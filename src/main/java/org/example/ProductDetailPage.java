package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {
    By basketButtonId = By.id("add-to-basket");
    By basketButtonXpath = By.xpath("//div[@class='basket-icon-title hidden-m hidden-t']");
    By productXpath = By.xpath("//div[@class='sc-1favwb2-0 bTbNwr']/ul/li");

    BasePage basePage = new BasePage(driver, wait, action);

    public ProductDetailPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    public void productSelect() {
        basePage.randomSelection(productXpath);
    }

    public void addToCard() {
        basePage.scroll(basketButtonId);
    }


    public void goToCard() {
        basePage.scroll(basketButtonXpath);
    }
}
