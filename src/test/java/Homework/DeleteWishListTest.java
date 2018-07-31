package Homework;

import exercise_nine.TestShopScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class DeleteWishListTest extends TestShopScenario {

    @Test
    public void deleteItemFromWishList() {

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
//        int number = 0;
//        for (int i = 0; i <= wishlist.size(); i++ ){
//            if (wishlist.get(i).getText().equals("Feel the pain")){
//                System.out.println(wishlist.get(i).getText());
//                number = 1143 +1;
//                i = wishlist.size();
//                String button = "tbody tr[id='wishlist_" +number+"']>td[class*=delete]>a";
//
//                // nog aan werken
//                wait.until(ExpectedConditions.alertIsPresent());
//                driver.switchTo().alert().accept();
//            }
//        }
    }



        @Test
        public void webTableHandler(){

            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("lianne@klaver.com");
            driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

            driver.findElement(By.id("SubmitLogin")).click();

            By wishlistButton = By.className("icon-heart");
            wait.until(ExpectedConditions.elementToBeClickable(wishlistButton));
            driver.findElement(wishlistButton).click();
            System.out.println("hoi");

//            By wishlistItem = By.cssSelector("tbody tr[id*='wishlist']>td>a");
//            List<WebElement> wishlist = driver.findElements(wishlistItem);
//            System.out.println(wishlist);

            String beforeXpath  = "//*[@id='block-history']/table/thead/tr/th[";
            String beforeXpathDos = "//*[id*='wishlist']/td[";
            String beforeXpathTres = "//*[@id='wishlist_";
            //vergeet ' niet voor tweede deel
            String afterXpathTres = "']/td[1]";

            for (int i = 1143; i<=1149; i++) {

                String actualxpath = beforeXpathTres + i + afterXpathTres;
                WebElement webElement = driver.findElement(By.xpath(actualxpath));
                System.out.println(webElement.getText());
            }





            //TR header?
            //*[@id="block-history"]/table/thead/tr/th[1]
            //*[@id="block-history"]/table/thead/tr/th[2]
            //*[@id="block-history"]/table/thead/tr/th[3]

            // TD is column
            //*[@id="wishlist_1145"]/td[1]
            //*[@id="wishlist_1146"]/td[1]

            //*[@id="wishlist_1145"]/td[2]
            //*[@id="wishlist_1145"]/td[3]

            //*[@id="wishlist_1148"]/td[1]
            //Qty
            //*[@id="wishlist_1145"]/td[2]


//        List  col = driver.findElements(By.xpath("//*[@id*='wishlist_']/td/a"));
//        System.out.println("No of cols are : " +col.size());
//        // no of cols
//        List  rows = driver.findElements(By.xpath("//*[@id*='wishlist_']/td/td[1]"));
//        System.out.println("No of rows are : " + rows.size());
//        // no of rows




    }
}
