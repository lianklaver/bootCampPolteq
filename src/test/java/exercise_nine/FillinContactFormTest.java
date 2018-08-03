package exercise_nine;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;


public class FillinContactFormTest extends TestShopScenario {

    @Test
    public void FillinContact() {
        //open the contact page
        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.contactUsButton).click();

        //Fill in contact form
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("Customer service", "lianne.klaver@polteq.com", "package", "bla bla bla bla bla" );

        //Assertion if succes alert is shown
        Assertions.assertThat(driver.findElements(By.cssSelector("#center_column > p")).size()).as("Success alert is shown after sending").isEqualTo(1);

    }
}
