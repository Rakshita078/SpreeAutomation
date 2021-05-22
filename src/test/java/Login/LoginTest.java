package Login;

import Pages.login;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Parameters({"email","password"})
    @Test
    public void testSuccessfulMessageOnValidLoginAndLogout(String email,String password) {
        login login = new login(driver);
        login.clickLoginButton();
        login.as(email, password);
        Assert.assertEquals(login.getLoginMessage(), "Logged in successfully");
        login.clickLogoutButton();
        Assert.assertEquals(login.getLogoutMessage(), "Signed out successfully.");
    }
    @Parameters({"email","password"})
    @Test
    public void testFailureMessageOnInvalidLogin(String email,String password) {
        login login = new login(driver);
        login.clickLoginButton();
        login.as(email, password);
        Assert.assertEquals(login.getInvalidLoginMessage(), "Invalid email or password.");

    }
}

