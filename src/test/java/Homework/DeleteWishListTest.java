package Homework;

import Pages.HomePage;
import Pages.LogInPage;
import Pages.MyAccountPage;
import Pages.WishListPage;
import exercise_nine.TestShopScenario;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

import java.util.List;


public class DeleteWishListTest extends TestShopScenario {

    public void openWishList(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.signInButton).click();

        LogInPage logInPage = new LogInPage(driver);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SubmitLogin > span")));
        logInPage.logIn("lianne@klaver.com", "1qazxsw2");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPage.wishlistButton));
        driver.findElement(myAccountPage.wishlistButton).click();
    }

    @Test
    public void deleteFeelThePain(){
        openWishList();

        WishListPage wishListPage = new WishListPage(driver);
        String itemName = "Fear the pain";
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

                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        }






    }


}
