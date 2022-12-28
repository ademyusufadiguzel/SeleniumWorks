package erolPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {

    /*
    - ebay sayfasina gidiniz
    - electronics bolumune tiklayiniz
    - genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
    - her sayfanin basligini yazdiralim
    - sayfayi kapatalim
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test1() {
        driver.get("https://ebay.com/");
        driver.findElement(By.xpath("//li[@data-currenttabindex='0']")).click();
        List<WebElement> imgList = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (int i = 0; i <imgList.size(); i++) {
            List<WebElement> allList = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            allList.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }
}
