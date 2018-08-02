package exercise_nine;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void contactFormTest(){
        HomePage homePage = new HomePage(driver);

        if(homePage.LoggedIn() == true){
            driver.findElement(homePage.signInButton).click();
        }

        driver.findElement(homePage.contactUsButton).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("Customer service", "bla@bla", "4321234", "<Help!>" );

        Assertions.assertThat(contactUsPage.errorMessage()).as("Alert is invalid Email").isEqualTo("Invalid email address.");
    }

    @Test
    public void contactFormTestInvalidValid(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        HomePage homePage = new HomePage(driver);

        if(homePage.LoggedIn() == true){
            driver.findElement(homePage.signInButton).click();
        }

        driver.findElement(homePage.contactUsButton).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        driver.findElement(contactUsPage.emailTextField).sendKeys("<nope>");
        //assertion op form error
        System.out.println(driver.findElement(By.className("form-error")).getAttribute("class"));

        driver.findElement(contactUsPage.emailTextField).clear();
        driver.findElement(contactUsPage.emailTextField).sendKeys("bla@bla.nl");

        //assertion op form positief
    }

}
