package erolPractice.Practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P03_Practice extends TestBase {

    //Amazon sayfasina gidelim
    //iphone aratalim
    //cikan urunlerden sadece Apple Iphone yazanlara tiklayalim

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        List<WebElement> products = driver.findElements(By.partialLinkText("Apple iPhone"));
        for (int i = 0; i < products.size(); i++) {
            products =  driver.findElements(By.partialLinkText("Apple  iPhone"));
            products.get(i).click();
            driver.navigate().back();
        }
        //StaleElementReferansException hatasini handle etmek icin loop icine webelementlerden olusturdugumuz
        //listi koymaliyiz, dinamik kod olmasi icin.
    }
}