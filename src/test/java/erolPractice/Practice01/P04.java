package erolPractice.Practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
    // Add Element butonuna 100 defa basınız
    // 100 defa basıldığını test ediniz
    // 90 defa delete butonuna basınız
    // 90 defa basıldığını doğrulayınız
    // Sayfayı kapatınız
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement elemetnsButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < 100; i++) {
            elemetnsButton.click();
        }


        Thread.sleep(3000);

    }
    @Test
    public void test02() {
        List<WebElement> listDelete = driver.findElements(By.xpath("//button[text()='Delete']"));

        Assert.assertEquals(100, listDelete.size());

        int count = 0;
        for (WebElement w : listDelete) {
            w.click();
            count++;
            if (count == 90) {
                break;
            }
        }

        Assert.assertEquals(90, count);
    }
}
