package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    By sizeOption = By.id("option-label-size-143-item-168");   // M
    By colorOption = By.id("option-label-color-93-item-57");   // Purple
    By addToCartBtn = By.id("product-addtocart-button");
    By successMessage = By.cssSelector("div[data-bind*='message.text']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCart() {
        WebElement size = wait.until(ExpectedConditions.elementToBeClickable(sizeOption));
        WebElement color = wait.until(ExpectedConditions.elementToBeClickable(colorOption));
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
        size.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", color);
        color.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);
        addBtn.click();
    }

    public boolean isAddedToCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}