package dataDriven;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercise_nine.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DataDrivenTest extends TestShopScenario {

    @Parameters({"subject", "email", "orderID", "message", "succes"})
    @Test
    public void FillinContact(String subject, String email, String orderID, String message, String succes) {
        //open the contact page
        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.contactUsButton).click();

        //Fill in contact form
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm(subject, email, orderID, message);

        String successfullTest = succes;
        if(successfullTest.equals("succesfull")) {
            //Assertion if succes alert is shown
            Assertions.assertThat(driver.findElements(By.cssSelector("#center_column > p")).size()).as("Success alert is shown after sending").isEqualTo(1);
        }
        else if(successfullTest.equals("messageFailure")){
            Assertions.assertThat(contactUsPage.errorMessage()).as("Alert is invalid Email").isEqualTo("The message cannot be blank.");
        }
        else {
            Assertions.assertThat(contactUsPage.errorMessage()).as("Alert is invalid Email").isEqualTo("Invalid email address.");
        }

    }
}
