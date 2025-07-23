package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.DriverFactory;

import java.time.Duration;

public class OrderPlacementTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = DriverFactory.initDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement consentParagraph = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("p.fc-button-label")));
            consentParagraph.click();
            System.out.println("Clicked Consent paragraph.");
        } catch (Exception e) {
            System.out.println("Consent paragraph not found or not clickable.");
        }
    }

    @Test
    public void placeOrderTest() {

        HomePage home = new HomePage(driver);
        home.clickFirstProduct();

        ProductPage product = new ProductPage(driver);
        product.addToCart();
        Assertions.assertTrue(product.isAddedToCart(), "Product was not added to Cart.");

        CartPage cart = new CartPage(driver);
        cart.openCart();
        cart.clickViewCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.clickProceedToCheckout();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}