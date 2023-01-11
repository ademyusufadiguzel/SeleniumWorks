package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day13 extends TestBase {

    //sahibinden.com a gidin
    //anasayfada oldugunuzu dogrulayin
    //detayli arama tiklayin
    //detayli arama sayfasina geldiginizi dogrulatin
    //emlak-konut-satilik seceneklerini secip
    //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
    //filtreler için sağıdakilere benzer methodlar oluşturun
    //detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
    //detayli_Arama_Fiyat("4.000","4.000.000","USD");
    //detayli_Arama_Brut("180","400");
    //detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
    //.
    //.
    //...
    //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin

    @Test
    public void test1(){
        driver.get("https://www.sahibinden.com/");
        Assert.assertEquals("https://www.sahibinden.com/", driver.getCurrentUrl());

        driver.findElement(By.id("onetrust-reject-all-handler")).click();

        driver.findElement(By.xpath("//a[@title='Detaylı Arama']")).click();

        Assert.assertEquals("https://www.sahibinden.com/arama/detayli",driver.getCurrentUrl());





    }

}
