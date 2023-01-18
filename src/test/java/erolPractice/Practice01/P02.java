package erolPractice.Practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P02 {

    static WebDriver driver;

    //go to url : https://www.techlistic.com/p/selenium-practice-form.html
    //fill the firstname
    //fill the lastname
    //check the gender
    //check the experience
    //fill the date
    //choose your profession -> Automation Tester
    //choose your tool -> Selenium Webdriver
    //choose your continent -> Antartica
    //choose your command  -> Browser Commands
    //click submit button

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Adem Yusuf");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Adiguzel");
        driver.findElement(By.cssSelector("input[id='sex-0']")).click();
        driver.findElement(By.cssSelector("input[id='exp-0']")).click();
        driver.findElement(By.cssSelector("input[id='datepicker']")).sendKeys("12/27/2022");
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        driver.findElement(By.cssSelector("input[id='tool-2']")).click();

        WebElement continents = driver.findElement(By.cssSelector("select[class='input-xlarge']"));
        Select option = new Select(continents);
        option.selectByVisibleText("Europe");

        WebElement commands = driver.findElement(By.cssSelector("select[id='selenium_commands']"));
        Select option2 = new Select(commands);
        option2.selectByVisibleText("Browser Commands");

        driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
    }
}
