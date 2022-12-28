package erolPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void setUp2() {
        driver.navigate().to("http://www.google.com");
    }
    //BeforeClass ile driver ı olusturun ve
    //Maximize edin, 15 sn bekletin
    //http://www.google.com adresine gidin
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //AfterClass ile kapatın
    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);
        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys( "Lord of the Rings", Keys.ENTER);
        Thread.sleep(3000);
    }
    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys( "Kill Bill", Keys.ENTER);
    }
    @After
    public void tearDown2() throws InterruptedException {
        String [] findedresult1 = driver.findElement(By.cssSelector("div[id='result-stats']")).getText().split(" ");
        System.out.println("Arama sonucu = "+ findedresult1[1]);
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
