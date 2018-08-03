package exercises;

import Pages.HomePage;
import Pages.LogInPage;
import exercise_nine.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogInSuccesFullPageObject extends TestShopScenario {

    @Test
    public void logInSuccesFull() {

        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.signInButton).click();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn("lianne.klaver@polteq.com", "Welkom01!");

        WebElement pageHeading = driver.findElement(By.className("page-heading"));
        Assertions.assertThat(pageHeading.getText()).as("Page name is MY ACCOUNT").isEqualTo("MY ACCOUNT");

    }

}
