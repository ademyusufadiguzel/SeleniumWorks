import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase03 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
        WebElement pageVisible = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(pageVisible.isDisplayed());

        driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();
        String actual = driver.findElement(By.xpath("//h2[text()='Login to your account']")).getText();
        String expected = "Login to your account";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test

    public void test2(){

        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("adiguzelademyusuf@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("ae200514");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        String actual = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).getText();
        String expected = "Your email or password is incorrect!";
        Assert.assertTrue(actual.contains(expected));

    }

}
