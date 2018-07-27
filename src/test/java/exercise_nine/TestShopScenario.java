package exercise_nine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestShopScenario {

    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
