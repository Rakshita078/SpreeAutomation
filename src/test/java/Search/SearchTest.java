package Search;

import Login.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void testSearchForShirt(){

        driver.findElement(By.id("keywords")).click();
        WebElement search = driver.findElement(By.id("keywords"));
        search.sendKeys("shirt");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.close();


    }



}
