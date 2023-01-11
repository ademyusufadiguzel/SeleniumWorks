package burakPractice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C04_ActionsMoveToElement extends TestBase {

    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        String window1 = driver.getWindowHandle();
        Actions actions = new Actions(driver);

        WebElement languageButton = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
        actions.moveToElement(languageButton).perform();

        WebElement changeCountryRegionButton = driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]"));
        changeCountryRegionButton.click();
        waitFor(5);

        WebElement dropdown = driver.findElement(By.xpath("//select[@data-action='a-dropdown-select']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Turkey (Türkiye)");
        waitFor(1);

        driver.findElement(By.xpath("//div[@class='a-column a-span12 a-ws-span5']//span[@class='a-text-bold']")).click();
        waitFor(1);

        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        Set<String> allwindows = driver.getWindowHandles();
        for (String w : allwindows){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
                break;
            }
        }

        String window2Title = driver.getTitle();
        Assert.assertTrue(window2Title.contains("Elektronik"));

        waitFor(5);
    }
}