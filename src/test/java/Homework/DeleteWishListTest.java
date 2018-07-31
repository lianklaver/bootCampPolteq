package Homework;

import Pages.HomePage;
import Pages.LogInPage;
import Pages.MyAccountPage;
import Pages.WishListPage;
import exercise_nine.TestShopScenario;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

import static java.lang.Thread.sleep;

public class DeleteWishListTest extends TestShopScenario {

//    public WebDriver driver = new ChromeDriver();
//
//    public HomePage homePage = new HomePage(driver);
//    public LogInPage logInPage = new LogInPage(driver);
//    public MyAccountPage myAccountPage = new MyAccountPage(driver);
//    public WishListPage wishListPage = new WishListPage(driver);

//    public void openWishList(){
//
//    }

    @Test
    public void deleteFeelThePain(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //openWishList();
        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.signInButton).click();

        LogInPage logInPage = new LogInPage(driver);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SubmitLogin > span")));
        logInPage.logIn("lianne@klaver.com", "1qazxsw2");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPage.wishlistButton));
        driver.findElement(myAccountPage.wishlistButton).click();

        WishListPage wishListPage = new WishListPage(driver);
        String itemName = "No Pain No Gain";
        wishListPage.deleteItem(itemName);

        Assertions.assertThat(wishListPage.itemOntheWishList(itemName)).as("Item " + itemName + "is not found on wishlist").isFalse();

    }

    public void lianneHaarTest() {

        WishListPage wishListPage = new WishListPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("lianne@klaver.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

        driver.findElement(By.id("SubmitLogin")).click();

        By wishlistButton = By.className("icon-heart");
        wait.until(ExpectedConditions.elementToBeClickable(wishlistButton));
        driver.findElement(wishlistButton).click();
        System.out.println("hoi");

        By wishlistItem = By.cssSelector("tbody tr[id*='wishlist']>td>a");
        List<WebElement> wishlist = driver.findElements(wishlistItem);
        System.out.println(wishlist);

        //My solution:
        int number = 0;
        for (int i = 0; i <= wishlist.size(); i++ ){
            if (wishlist.get(i).getText().equals("Feel the pain")){
                System.out.println(wishlist.get(i).getText());
                number = 1143 + i;
                i = wishlist.size();
                String button = "tbody tr[id='wishlist_" +number+"']>td[class*=delete]>a";

                //wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        }






    }


}
