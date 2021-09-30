package org.test;

import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Main extends Base {
    String homePageTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";

    public void driverWait() {
        this.driver.manage().timeouts().implicitlyWait(40L, TimeUnit.SECONDS);
    }

    @Test
    @Order(1)
    public void goToHomePageUrl() {

        logger.info("HomePage Check");
        homePage.goToHomePageUrl();
        driverWait();
        homePage.verifyPageLoaded();
        logger.info("Check HomePage Title");
        Assert.assertTrue(driver.getTitle().equals(homePageTitle));
        driverWait();
        logger.info("HomePage check complete");
    }

    @Test
    @Order(2)
    public void acceptCookie() {
        homePage.acceptCookies();
    }

    //@Test
    //@Order(3)
    public void login() throws InterruptedException {
        logger.info("Login process started");
        homePage.hoverClickButton();
        driverWait();
        homePage.clickLogin();
        driverWait();
        loginPage.sendKeys();
        driverWait();
        loginPage.clickLogin();
        logger.info("Login Check Done");

    }

    @Test
    @Order(4)
    public void searchProducts() {
        driverWait();
        logger.info("SearchPage Check");
        searchListPage.sendKeys();
        searchListPage.searchButtonClick();
    }

    @Test
    @Order(5)
    public void searchResult() throws InterruptedException {
        driverWait();
        searchListPage.secondPageClick();
        logger.info("Check SearchPage");
        driverWait();
        Assert.assertTrue(searchListPage.secondPageVerify().equals("2"));
        driverWait();
        logger.info("SearchPage Check Done");
    }

    @Test
    @Order(6)
    public void productDetail() throws InterruptedException {
        productDetailPage.productSelect();
        driverWait();
        productDetailPage.addToCard();
        Thread.sleep(3000);
        productDetailPage.goToCard();
        driverWait();
        logger.info("CardPage Check");
        Thread.sleep(5000);
    }

    @Test
    @Order(7)
    public void basketPageTransactions() throws InterruptedException {

        logger.info("Check Price");
        String oldPrice = cardPage.totalPriceOne();
        assertEquals(cardPage.getBasketPrice(), oldPrice);
        logger.info("Check Quantity");
        Thread.sleep(3000);
        cardPage.increaseProductQuantity();
        Thread.sleep(3000);
        logger.info("Check Card");
        assertNotEquals(oldPrice, cardPage.totalPriceTwo());
        Thread.sleep(3000);
        cardPage.deleteProduct();
        logger.info("CardPage Check Done");
    }


    @Test
    @Order(8)
    public void quitDriver() {
        driverWait();
        logger.info("Driver Quit");
        this.driver.quit();
    }
}

