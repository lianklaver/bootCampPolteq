package exercise_nine;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void contactFormTest(){
        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.contactUsButton).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("Customer service", "<nope>", "4321234", "<Help!>" );

        Assertions.assertThat()
    }

}
