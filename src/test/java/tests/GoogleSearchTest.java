package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void searchShouldReturnResults() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium TestNG framework");
        searchBox.submit();

        Assert.assertTrue(driver.getTitle().contains("Selenium"),
                "Page title should contain the search term");
    }
}