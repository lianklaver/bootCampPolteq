package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishListPage {

        //https://techblog.polteq.com/testshop/index.php?fc=module&module=blockwishlist&controller=mywishlist
        private final WebDriver driver;

        private By items = By.xpath("//*[@id='block-history']/table/tbody/tr");
        private By columnTitles = By.xpath("//*[@id='block-history']/table/thead/tr/th");

        public WishListPage(WebDriver driver){ this.driver = driver; }

        public void deleteItem(String itemWishList){

            List<WebElement> rows = driver.findElements(items);
            int rowCount = rows.size();
            String beforeXpathRow = "//*[@id='block-history']/table/tbody/tr[";
            String afterXpathRow = "]/td/a";

            // methode to determine startpoint i
            int rowNumber = 0;
            for (int i = 1; i<=rowCount; i++) {
                String actualxpath = beforeXpathRow + i + afterXpathRow;
                WebElement element = driver.findElement(By.xpath(actualxpath));
                System.out.println(element.getText());

                if(element.getText().equals(itemWishList)){
                    System.out.println("item on wishlist : " + element.getText() + " is found" + "at position : " + i);
                    rowNumber = i;
                    break;
                }
            }

            if(rowNumber <= 0){
                System.out.println("item " + itemWishList + " was not found on the wishlist, so can't be deleted");
                throw new NullPointerException();
            }

            List<WebElement> columns = driver.findElements(columnTitles);
            int columnCount = columns.size();

            String beforeXpathColumn = "//*[@id='block-history']/table/tbody/tr[" + rowNumber + "]/td[";
            String afterXpathColumn = "]";

            String deleteButtonXpath = null;
            for (int i = 1; i<= columnCount; i++){
                String actualXpathColumn = beforeXpathColumn + i + afterXpathColumn;
                WebElement element = driver.findElement(By.xpath(actualXpathColumn));

                if (element.getAttribute("class").equals("wishlist_delete")){
                    deleteButtonXpath = actualXpathColumn + "/a";
                    System.out.println(deleteButtonXpath);
                    break;
                }
            }

            driver.findElement(By.xpath(deleteButtonXpath)).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

        public boolean itemOntheWishList(String itemWishList){
            List<WebElement> rows = driver.findElements(items);
            int rowCount = rows.size();
            String beforeXpathRow = "//*[@id='block-history']/table/tbody/tr[";
            String afterXpathRow = "]/td/a";

            int rowNumber = 0;

            for (int i = 1145; i<=rowCount; i++) {
                String actualxpath = beforeXpathRow + i + afterXpathRow;
                WebElement element = driver.findElement(By.xpath(actualxpath));
                if(element.getText().equals(itemWishList)){
                    System.out.println("item on wishlist : " + element.getText() + " is found" + "at position : " + i);
                    return true;
                }
            }

            System.out.println("item not found on the wishlist");
            return false;
        }

}


