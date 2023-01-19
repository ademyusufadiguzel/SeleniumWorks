package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    //    TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
//    TestBase testBase = new TestBase(); -> YAPILAMAZ
//    Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak
//    driver objesini olustur. Driver ya public yada protected olmali.
//    Sebepi child classlarda gorulebilir olmasi
    protected static WebDriver driver;

    //    setUp
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //    tearDown
    @After
    public void tearDown() {
        driver.quit();
    }

    //    MULTIPLE WINDOW:
    //    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
    //    ORNEK:
    //    driver.get("https://the-internet.herokuapp.com/windows");
    //    switchToWindow("New Window");
    //    switchToWindow("The Internet")
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //    windowNumber sıfır (0)'dan başlıyor.
    //    index numarasini parametre olarak alir
    //    ve o indexli pencerece gecis yapar
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber-1));
    }

    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //FULL SCREEN SCREENSHOT
    public void screenShotOfElement() throws IOException {
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = "target/ScreenShots"+currentDate+"image.png";
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), new File(path));
    }

    //ELEMENT SCREENSHOT
    public void screenShotOfElement(WebElement element) throws IOException {
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = "target/ScreenShots"+currentDate+"image.png";
        File image = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image, new File(path));
    }
}