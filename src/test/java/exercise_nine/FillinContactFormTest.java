package exercise_nine;

import Pages.ContactUsPage;
import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

public class FillinContactFormTest extends TestShopScenario {

    @Test
    public void FillinContact() {
        //open contact page
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("Customer service", "lianne.klaver@polteq.com", "package", "bla bla bla bla bla" );
        //driver.findElement(By.className("alert alert-success"));
        boolean check = driver.findElement(By.className("alert alert-success")).getSize() >= 0;
        Assertions.assertThat(check).as("Send is succesfull").isTrue();

    }
}
