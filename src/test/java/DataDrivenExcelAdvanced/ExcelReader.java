package DataDrivenExcelAdvanced;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static String ColName="Result";
    public int col_num;


    public static Object[][] getTableArray(String filePath, String sheetName, int iTestCaseRow)    throws Exception

    //public static Object[][] ReadVariant() throws IOException

    {
        DataFormatter formatter = new DataFormatter();

        FileInputStream fileInputStream= new FileInputStream(filePath); //Excel sheet file location get mentioned here
        workbook = new HSSFWorkbook (fileInputStream); //get my workbook
        worksheet = workbook.getSheet(sheetName);// get my sheet from workbook
        HSSFRow Row = worksheet.getRow(iTestCaseRow);     //get my Row which start from 0

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
