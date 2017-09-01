package Pages;

import Utils.Tools;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;

public class LoginPage extends Tools{

    private final String SERVICE_URL = "https://vidoza.net/login.html";
    private final String USERNAME = "bapohka1";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("Page elements at LoginPage are initialized");
    }

    @FindBy(css = "div>input[name='login']")
    private WebElement email_field;
    @FindBy(css = "div>input[name='password']")
    private WebElement pass_field;
    @FindBy(css = "input[type='submit']")
    private WebElement signIn;


    private void doLogin(String PASS){
        driver.navigate().to(SERVICE_URL);
        email_field.sendKeys(USERNAME);
        pass_field.sendKeys(PASS);
        signIn.click();
        sleep(5);
    }

    public void doSuccess() throws IOException {
        doLogin("10813666");
        Assert.assertTrue(driver.findElement(By.cssSelector("div.usertype_mark")).getText()
                .contains("Account Type: "));
        makeScreen();
    }


    public void doFailure(){
        doLogin("wrong password");
        Assert.assertTrue(false);

    }
}