package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardPage extends BasePage {
    By priceName = By.className("total-price");
    By basketButtonName = By.className("header-cart-hidden-link");
    By basketPrice = By.xpath("//p[@class='new-price']");
    By productIncreaseXpath = By.xpath("//*[@class='amount']/option[@value=2]");
    By deleteButtonName = By.className("btn-delete");

    BasePage basePage = new BasePage(driver, wait, action);

    public CardPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    public String totalPriceOne() {
        return basePage.getText(priceName);
    }

    public String totalPriceTwo() {
        return basePage.getText(priceName);
    }

    public String getBasketPrice() {
        return basePage.getText(basketPrice);
    }

    public void increaseProductQuantity() {
        breakTime();
        basePage.click(productIncreaseXpath);
    }

    public void deleteProduct() {
        basePage.click(deleteButtonName);
    }

    private void breakTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
