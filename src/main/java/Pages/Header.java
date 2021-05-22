package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {

    private WebDriver driver;

    @FindBy(css = ".alert.alert-success")
    private WebElement loginMessage;
    @FindBy(css = ".alert.alert-notice")
    private WebElement logoutMessage;
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;
    @FindBy(css = ".alert.alert-error")
    private WebElement invalidLoginMessage;

    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        driver.findElement(By.id("link-to-login")).click();
    }

    public String getLoginMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginMessage));
        return loginMessage.getText();
    }
    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
    public String getLogoutMessage() {
        return logoutMessage.getText();
    }
    public String getInvalidLoginMessage(){
        return invalidLoginMessage.getText();

    }
}
