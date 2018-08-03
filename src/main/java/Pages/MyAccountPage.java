package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private final WebDriver driver;

    public By wishlistButton = By.className("icon-heart");

    public MyAccountPage(WebDriver driver){ this.driver = driver; }
}
