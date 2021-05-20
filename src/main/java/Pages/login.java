package Pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login extends Header {
    private WebDriver driver;
    @FindBy(id = "spree_user_email")
    private WebElement userName;
    @FindBy(id = "spree_user_password")
    private WebElement passwd;
    @FindBy(name = "commit")
    private WebElement submitButton;

    public login(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void as(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys(email);
        passwd.sendKeys(password);
        submitButton.click();
    }


}
