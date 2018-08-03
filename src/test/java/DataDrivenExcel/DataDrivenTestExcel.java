package DataDrivenExcel;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercise_nine.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

//excel imports
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;


public class DataDrivenTestExcel extends TestShopScenario {

   // @Parameters({"subject", "email", "orderID", "message", "succes"})
    @Test
            (dataProvider="ReadVariant") //It get values from ReadVariant function method
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
    public static Object[][] ReadVariant() throws IOException {

        HSSFWorkbook workbook;
        HSSFSheet worksheet;
        String ColName="Result";
        int col_num;
        DataFormatter formatter = new DataFormatter();

            FileInputStream fileInputStream= new FileInputStream("/Users/lianne/Documents/workspace/bootCampPolteq/DataDriven/dataExcel2.xls"); //Excel sheet file location get mentioned here
            workbook = new HSSFWorkbook (fileInputStream); //get my workbook
            worksheet = workbook.getSheet("Sheet1");// get my sheet from workbook
            HSSFRow Row = worksheet.getRow(0);     //get my Row which start from 0

            int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
            int ColNum= Row.getLastCellNum(); // get last ColNum

            Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {
                HSSFRow row= worksheet.getRow(i+1);

                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        HSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
            }

            return Data;
        }
}
