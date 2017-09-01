package Pages;

import Utils.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Tools {
    private final String SERVICE_URL = "https://vidoza.net";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("Page elements at MainPage are initialized");

    }

    @FindBy(css = "div>input[name='login']")
    private WebElement email_field;



}
