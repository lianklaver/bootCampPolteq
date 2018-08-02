package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.assertj.core.api.Assertions;


public class LogInPage {

    private final WebDriver driver;

    private By emailField = By.cssSelector("#email");
    private By passwordField = By.cssSelector("#passwd");
    public By sumitButton = By.cssSelector("#SubmitLogin > span");

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public void logIn (String email, String password){

        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(sumitButton).click();
        Assertions.assertThat(driver.findElement(By.className("page-heading")).getText()).as("Log in went succesfully").isEqualTo("MY ACCOUNT");
    }
}
