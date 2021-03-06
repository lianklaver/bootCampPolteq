package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    //https://techblog.polteq.com/testshop/index.php?controller=contact
    private final WebDriver driver;

    public By emailTextField = By.cssSelector("input#email");
    private By orderReferenceTextField = By.cssSelector("input#id_order");
    private By messageTextField = By.cssSelector("textarea#message");
    private By sendButton = By.cssSelector("button#submitMessage");
    private By invalidEntryElement = By.cssSelector(".alert.alert-danger>ol");
    private By subjectDropDownMenu = By.id("id_contact");



    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInContactForm(String subject, String email, String orderReference, String message) {

        Select dropdown = new Select(driver.findElement(subjectDropDownMenu));
        dropdown.selectByVisibleText(subject);

        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(orderReferenceTextField).sendKeys(orderReference);
        driver.findElement(messageTextField).sendKeys(message);
        driver.findElement(sendButton).click();
    }

    public String errorMessage() {
        try {
            return driver.findElement(invalidEntryElement).getText();
        } catch (NoSuchElementException exception) {
            System.out.println("No alert on page");
            return "";
        }
    }
}
