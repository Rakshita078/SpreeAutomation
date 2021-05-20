package Login;

import Base.BaseTest;
import Pages.login;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Parameters({"email"})
    @Test
    public void testSuccessfulMessageOnValidLoginAndLogout(String email) {
        login login = new login(driver);
        login.clickLoginButton();
        login.as(email, "raksh123");
        Assert.assertEquals(login.getLoginMessage(), "Logged in successfully");
        tearDown();
    }
}

