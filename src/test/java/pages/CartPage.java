package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    By cartIcon = By.cssSelector("a.action.showcart");
    By viewCart = By.cssSelector("a.action.viewcart");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void clickViewCart() {
        driver.findElement(viewCart).click();
    }
    public void openMiniCartAndProceedToCheckout() {
        WebElement miniCartToggle = driver.findElement(By.cssSelector("a.action.showcart"));
        miniCartToggle.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
        checkoutBtn.click();
    }

    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement miniCartToggle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.showcart")));
        miniCartToggle.click();

        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);

        try {
            checkoutBtn.click();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);
        }
    }
}
