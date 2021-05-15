package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchTest {
    @Test
    public void testSearchForShirt(){
        System.setProperty("webdriver.chrome.driver", "/Users/rakshita/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.findElement(By.id("keywords")).click();
        WebElement search = driver.findElement(By.id("keywords"));
        search.sendKeys("shirt");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.close();


    }



}
