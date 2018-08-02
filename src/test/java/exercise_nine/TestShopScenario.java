package exercise_nine;

import Browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestShopScenario {

    protected WebDriver driver;

    @BeforeClass
    public void setup(){
       // String browser = "Chrome";
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);

//        if(browser.equals("IE")){
//            driver.manage().window().;
//            driver.get("https://techblog.polteq.com/testshop/index.php");
//        }

//        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
