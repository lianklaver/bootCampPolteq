package DataDrivenExcelAdvanced;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercise_nine.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestExcelAdvanced extends TestShopScenario {

    @Test(dataProvider="ReadVariant") //It get values from ReadVariant function method
    public void FillinContact(String subject, String email, String orderID, String message, String succes) throws Exception
    {
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

    @DataProvider

    public Object[][] ReadVariant() throws Exception{

        Object[][] testObjArray = ExcelReader.getTableArray("/Users/lianne/Documents/workspace/bootCampPolteq/DataDriven/dataExcel2.xls","Sheet1", 0);

        return (testObjArray);

    }

}
