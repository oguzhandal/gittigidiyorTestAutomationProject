package org.test;

import org.apache.log4j.PropertyConfigurator;
import org.example.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Base {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SearchListPage searchListPage;
    protected ProductDetailPage productDetailPage;
    protected CardPage cardPage;
    Logger logger;

    @BeforeAll
    public void setup() {
        String projectPath = System.getProperty("user.dir");
        String log4jConfPath = projectPath + "/src/test/resources/log4j2.properties";
        PropertyConfigurator.configure(log4jConfPath);
        logger = LoggerFactory.getLogger(Base.class.getName());

        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        this.driver.get(url);
        this.driver.manage().window().maximize();


        homePage = new HomePage(driver, wait, action);
        loginPage = new LoginPage(driver, wait, action);
        searchListPage = new SearchListPage(driver, wait, action);
        productDetailPage = new ProductDetailPage(driver, wait, action);
        cardPage = new CardPage(driver, wait, action);
    }


    @AfterAll
    public void quitDriver() throws InterruptedException {
        logger.info("Test Ended");
        this.driver.quit();
    }
}
