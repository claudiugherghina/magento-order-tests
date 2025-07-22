package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class OrderPlacementTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void dummyTest() {
        Assertions.assertTrue(driver.getTitle().contains("Home Page"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
