package browserDriven;

import Browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(BrowserFactoryAdvanced.Browser browser){
       // String browser = "Chrome";
        driver = BrowserFactoryAdvanced.getDriver(browser);

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
