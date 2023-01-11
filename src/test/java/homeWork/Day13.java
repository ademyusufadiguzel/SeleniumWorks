package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        driver.findElement(By.xpath("//span[.='Emlak']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[.='Konut']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[.='Satılık']")).click();
        waitFor(1);

        adressFilter("Manisa", "Yunusemre","Kaynak Mh.");

        waitFor(5);
    }

    public void adressFilter(String il, String ilce, String semt){
        WebElement ilSelect = driver.findElement(By.xpath("//li[@data-address='city']//a[@class='faceted-select']"));
        WebElement ilceSelect = driver.findElement(By.xpath("//li[@data-address='town']//a[@class='faceted-select']"));
        WebElement semtSelect = driver.findElement(By.xpath("//li[@data-address='quarter']//a[@class='faceted-select']"));
        WebElement closePanel = driver.findElement(By.xpath("//a[@class='collapse-pane']"));

        Actions actions = new Actions(driver);
        actions.click(ilSelect).sendKeys(il).click(closePanel).build().perform();
        waitFor(1);
        actions.click(ilceSelect).sendKeys(ilce).click(closePanel).build().perform();
        waitFor(1);
        actions.click(semtSelect).sendKeys(semt).click(closePanel).build().perform();
        waitFor(1);


    }

}
