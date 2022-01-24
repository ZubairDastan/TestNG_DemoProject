import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRunner extends EnvironmentSetup {

    @Test
    public void hitLogin() throws Exception {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils();
        utils.readFromJsonArray(0);
        String user = login.validMailPass(utils.getMail(), utils.getPass());
        Assert.assertEquals(user, "Test User");
    }

    @Test
    public void loginInvalidEmail() throws Exception {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils();
        utils.readFromJsonArray(1);
        String user = login.loginInvalidMail(utils.getMail(), utils.getPass());
        Assert.assertEquals(user, "Invalid email address");
    }

    @Test
    public void loginInvalidPass() throws Exception {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils();
        utils.readFromJsonArray(2);
        String user = login.loginInvalidPass(utils.getMail(), utils.getPass());
        Assert.assertEquals(user, "Authentication error");
    }
}
