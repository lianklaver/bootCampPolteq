package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public By signInButton = By.className("login");
    public By contactUsButton = By.cssSelector("#contact-link > a");

    public HomePage(WebDriver driver){ this.driver = driver; }
}
