package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LoginTest {
    @Test
    public void testLoginIntoSpree() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/rakshita/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        //driver.quit();
        //Thread.sleep(5000);
        WebElement login_icon = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/nav/ul/li[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("link-to-login")));
        login_icon.click();


        driver.close();
    }

    @Test
    public void testSuccessfulMessageOnValidLogin() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/rakshita/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/login");

        WebElement email = driver.findElement(By.id("spree_user_email"));
        email.sendKeys("rakshita@gmail.com");
        driver.findElement(By.id("spree_user_password")).click();
        WebElement password = driver.findElement(By.id("spree_user_password"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("raksh123");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.cssSelector(".alert")).click();
        assertThat(driver.findElement(By.cssSelector(".alert")).getText(), is("Logged in successfully"));
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();

    }


    @Test
    public void testErrorMessageOnInvalidLogin() {
        System.setProperty("webdriver.chrome.driver", "/Users/rakshita/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/login");

        WebElement email = driver.findElement(By.id("spree_user_email"));
        email.sendKeys("rakshita@gmail.com");
        driver.findElement(By.id("spree_user_password")).click();
        WebElement password = driver.findElement(By.id("spree_user_password"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("raksh12");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.cssSelector(".alert")).click();
        assertThat(driver.findElement(By.cssSelector(".alert")).getText(), is("Invalid email or password."));
        driver.close();

    }
}

