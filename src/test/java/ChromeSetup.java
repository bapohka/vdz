import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class ChromeSetup {
    protected ChromeOptions options;
    protected WebDriver driver;

    @BeforeTest
    protected void startChrome()  throws Exception {
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--lang=en");
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        if (SystemUtils.IS_OS_MAC) {
            System.setProperty("webdriver.chrome.driver", "bin/chromedriver/mac64");
        }   if(SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", "bin/chromedriver/win32.exe");
        }   if(SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", "bin/chromedriver/linux64");
        }
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
