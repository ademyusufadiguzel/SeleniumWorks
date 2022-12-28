package erolPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    static WebDriver driver;
    /*
    -"amazon.com" adresine gidelim
    -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    -title ve url'nin "amazon" kelimesinin icerip icermedigini kontrol edelim
    -Ardindan "trendyol.com" adresine gidelim
    -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
    -Bi onceki web sayfamiza geri donelim
    -sayfayi yenileyelim
    -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
     */

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String pageTitle = driver.getTitle();
        String pageURL = driver.getCurrentUrl();
        System.out.println("Page title : " + pageTitle + "\n" +
                "Page URL : " + pageURL);

        String expectedTitle = "spend";
        String expectedURL = "spend";
        Assert.assertFalse(pageTitle.equals(expectedTitle));
        Assert.assertFalse(pageURL.equals(expectedURL));
    }
    @Test
    public void test02() throws InterruptedException {
        driver.navigate().to("https://trendyol.com");
        String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.close();
    }
}
