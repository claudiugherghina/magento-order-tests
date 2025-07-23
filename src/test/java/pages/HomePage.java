package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    By firstProduct = By.cssSelector("li.product-item a.product-item-link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> products = driver.findElements(firstProduct);
        if (!products.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(products.get(0))).click();
        } else {
            throw new RuntimeException("No product found on the page.");
        }
    }
}
