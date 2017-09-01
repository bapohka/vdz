import Pages.LoginPage;
import Pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;


public class TestCases extends ChromeSetup {
    protected LoginPage loginPage;
    protected MainPage mainPage;

    @BeforeTest
    protected void initDBPages() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

    }

    @Test (description = "login on site")
    public void successLogin() throws IOException {
        loginPage.doSuccess();
        }


}
