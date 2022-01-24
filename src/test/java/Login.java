import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    @FindBy(className = "login")
    WebElement linkLogin;
    WebDriver driver;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "passwd")
    WebElement txtPassword;
    @FindBy(id = "SubmitLogin")
    WebElement btnSubmitLogin;
    @FindBy(xpath = "//span[contains(text(),'Test User')]")
    WebElement lblUserName;
    @FindBy(xpath = "//li[contains(text(),'Invalid email address')]")
    WebElement lblInvalidEmail;
    @FindBy(xpath = "//li[contains(text(),'Authentication error')]")
    WebElement lblInvalidPass;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String validMailPass(String email, String password) {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblUserName.getText();
    }

    public String loginInvalidMail(String email, String password) {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblInvalidEmail.getText();
    }

    public String loginInvalidPass(String email, String password) {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblInvalidPass.getText();
    }
}
