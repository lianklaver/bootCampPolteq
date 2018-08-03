package dataDrivenLogIn;

import Pages.HomePage;
import Pages.LogInPage;
import exercise_nine.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenTestLogIn extends TestShopScenario {

    @Parameters({"email", "password", "result"})
    @Test
    public void logInSuccesFull(String email, String password, String result) {

        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.signInButton).click();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn(email, password);

        WebElement pageHeading = driver.findElement(By.className("page-heading"));
        Assertions.assertThat(pageHeading.getText()).as("Page name is MY ACCOUNT").isEqualTo(result);

    }

}
