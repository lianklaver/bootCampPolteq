package exercise_nine;

import Pages.HomePage;
import org.testng.annotations.Test;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void contactFormTest(){
        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.contactUsButton).click();
    }

}
