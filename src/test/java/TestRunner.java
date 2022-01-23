import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;

public class TestRunner extends EnvironmentSetup {

    @Test
    public void hitLogin() throws Exception {
        driver.get("http://automationpractice.com");
        Login login = new Login(driver);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");
        String user = login.doLogin(email, password);
        Assert.assertEquals(user, "Test User");
    }
}
