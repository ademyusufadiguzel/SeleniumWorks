import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase02 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test1(){
        WebElement homePage = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(homePage.isDisplayed());

        driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();
        String actual = driver.findElement(By.xpath("//h2[text()='Login to your account']")).getText();
        String expected = "Login to your account";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("adiguzelademyusuf@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("ADEMyusuf585.");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        Thread.sleep(2000);

    }

    @Test
    public void test3() throws InterruptedException {
        WebElement usernameDisplay = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(usernameDisplay.isDisplayed());

        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
        Thread.sleep(3000);

        String actual = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        String expected = "Account Deleted!";
        Assert.assertTrue(actual.equals(expected));

    }

}
