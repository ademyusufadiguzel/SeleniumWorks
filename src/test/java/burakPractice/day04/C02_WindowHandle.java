package burakPractice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Best Buy"));

        switchToWindow(1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        String searchResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(searchResult.contains("java"));

        switchToWindow(2);
        WebElement w2Logo = driver.findElement(By.xpath("//div[@lang='en']//img[@class='logo']"));
        Assert.assertTrue(w2Logo.isDisplayed());

        waitFor(3);
    }
}