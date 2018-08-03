package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public By signInButton = By.className("login");
    public By contactUsButton = By.cssSelector("#contact-link > a");
    private By userInfoField = By.className("login");


    public HomePage(WebDriver driver){ this.driver = driver; }

    public boolean LoggedIn(){
        if(driver.findElement(userInfoField).getText().equals("Sign in")){
            return false;
        }
        else {
            return true;
        }
    }
}
