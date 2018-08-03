package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by MiesMSI on 6-7-2017.
 */
public class BrowserFactoryAdvanced {

    public enum Browser{
        FIREFOX,
        IE,
        CHROME;
    }


    public static WebDriver getDriver(Browser browser){
        switch(browser) {
            case FIREFOX:
                return createFireFoxBrowser();
            case IE:
                return createIEBrowser();
            case CHROME:
                return createChromeBrowser();
            default:
                return createChromeBrowser();
        } // end switch
    }

    private static WebDriver createChromeBrowser() {
        //Chrome options are chrome specific
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-infobars");
        //Capabilities can used for WebDriver capabilities ie: proxy
        options.setCapability("chrome.switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver createFireFoxBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        options.setCapability("javascriptEnabled", true);
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(options);
    }

    private static WebDriver createIEBrowser() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("http://www.nu.nl");
        InternetExplorerDriverManager.getInstance().setup();
        return new InternetExplorerDriver(options);
    }
}

//import io.github.bonigarcia.wdm.ChromeDriverManager;
//        import io.github.bonigarcia.wdm.EdgeDriverManager;
//        import io.github.bonigarcia.wdm.FirefoxDriverManager;
//        import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.chrome.ChromeDriver;
//        import org.openqa.selenium.chrome.ChromeOptions;
//        import org.openqa.selenium.edge.EdgeDriver;
//        import org.openqa.selenium.firefox.FirefoxDriver;
//        import org.openqa.selenium.ie.InternetExplorerDriver;
//
//public class BrowserFactoryAdvanced {
//    public static WebDriver getDriver(String browser) {
//        WebDriver driver;
//
//        public static WebDriver browserStartup(Browsers browser){
//            //loopt door de opties heen en als gelijk aan input dan start hij die driver op
//            switch (browser) {
//                case FIREFOX:
//                    FirefoxDriverManager.getInstance().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                case IE:
//                    InternetExplorerDriverManager.getInstance().setup();
//                    driver = new InternetExplorerDriver();
//                    break;
//                case CHROME:
//                    ChromeDriverManager.getInstance().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case EDGE:
//                    EdgeDriverManager.getInstance().setup();
//                    driver = new EdgeDriver();
//                    break;
//                default:
//                    driver = new ChromeDriver();
//            }
//        return driver;
//    }
//
//    private static WebDriver createChromeBrowser() {
//            //Chrome options
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("start-maximized");
//            options.addArguments("ignore-certificate-errors");
//            options.addArguments("disable-infobars");
//
//            //capabilities
//            options.setCapability("chrome.switches", "--verbose");
//            ChromeDriverManager.getInstance().setup();
//            return new ChromeDriver(options);
//
//        }
//    }
//}

