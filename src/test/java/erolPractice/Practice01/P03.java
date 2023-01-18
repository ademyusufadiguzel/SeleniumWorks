package erolPractice.Practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Print the result
    // close driver
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.cssSelector("a[id='calculatetest']")).click();
        driver.findElement(By.cssSelector("input[id='number1']")).sendKeys("200", Keys.TAB, Keys.TAB, "100", Keys.ENTER);
        String result = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println(result);
        Thread.sleep(3000);

        driver.close();
    }
}
