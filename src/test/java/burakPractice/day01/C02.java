package burakPractice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
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
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        WebElement dropdown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select option = new Select(dropdown);
        option.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String selectedOption = option.getFirstSelectedOption().getText();
        System.out.println(selectedOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> list = option.getOptions();
        long actual = list.size();
        long expected = 28;

        Assert.assertEquals(expected, actual);
    }
}
