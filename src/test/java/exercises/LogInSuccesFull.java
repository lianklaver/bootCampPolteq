package exercises;

import exercise_nine.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogInSuccesFull extends TestShopScenario {

    @Test
    public void logInSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("lianne.klaver@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Welkm01!");

        driver.findElement(By.id("SubmitLogin")).click();

        //Assert.assertTrue(driver.findElements(By.className("info-account")).size() > 0);

        WebElement pageHeading = driver.findElement(By.className("page-heading"));
        Assertions.assertThat(pageHeading.getText()).as("Page name is MY ACCOUNT").isEqualTo("MY ACCOUNT");

        WebElement contactLink = driver.findElement(By.id("contact-link"));
        System.out.println(contactLink.getText());
        Assertions.assertThat(contactLink.getText()).as("Not Empty").doesNotContain("Contact us");

        boolean check = driver.findElement(By.id("contact-link")).getText().equals("MY ACCOUNT");
        Assertions.assertThat(check).as("My account is header").isTrue();
        //Assert.assertEquals(pageHeading.getText(), "MY ACCOUNT");
        driver.quit();
    }

}
