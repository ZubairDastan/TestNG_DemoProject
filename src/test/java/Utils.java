import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public String mail;
    public String Pass;
    WebDriver driver;
    public void utils (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public void readFromJson () throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject jsonObject = (JSONObject) object;
        setMail((String) jsonObject.get("email"));
        setPass((String) jsonObject.get("password"));
    }

    public void readFromJsonArrray (int positoin) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) object;
        JSONObject jsonObject = (JSONObject) jsonArray.get(positoin);
        setMail((String) jsonObject.get("email"));
        setPass((String) jsonObject.get("password"));
    }
}
