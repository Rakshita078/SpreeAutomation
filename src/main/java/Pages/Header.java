package Pages;

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

    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getLoginMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginMessage));
        return loginMessage.getText();

    }
}
