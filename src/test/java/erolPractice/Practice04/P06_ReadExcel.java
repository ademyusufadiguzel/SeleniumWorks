package erolPractice.Practice04;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class P06_ReadExcel{

    //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
    //https://www.bluerentalcars.com/ adresine gidip
    //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    //Login olduğumuzu doğrulayalım

    @Test
    public void readExcelTest() throws IOException {
        String path = "C:\\Users\\Adem Yusuf\\Downloads\\TestCaseExample.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        String email = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println(email);



    }

}
