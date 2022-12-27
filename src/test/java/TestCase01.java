import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestCase01 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test01() {
        Assert.assertTrue(driver.findElement(By.cssSelector("html[lang='en']")).isDisplayed());
    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();
        Thread.sleep(5000);

        WebElement newUserText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        String actual = newUserText.getText();
        String expected = "New User Signup!";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Lawsted");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("adiguzelademyusuf@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        String actualTitle = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText();
        String expectedTitle = "ENTER ACCOUNT INFORMATION";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Thread.sleep(5000);
    }

    @Test
    public void test04() throws InterruptedException {
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();
        driver.findElement(By.cssSelector("input[data-qa='password']")).sendKeys("ADEMyusuf585.");

        driver.findElement(By.xpath("//*[text()='5']")).click();
        driver.findElement(By.xpath("//*[text()='October']")).click();
        driver.findElement(By.xpath("//*[text()='2005']")).click();

        driver.findElement(By.cssSelector("input[name='newsletter']")).click();
        driver.findElement(By.cssSelector("input[name='optin']")).click();

        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Adem Yusuf");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Adiguzel");

        driver.findElement(By.cssSelector("input[name='company']")).sendKeys("Ev");

        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Lalapasa mah. 4710 sk. No:16 Daire:3 Kardelen apt.");
        driver.findElement(By.cssSelector("input[name='address2']")).sendKeys("Yunusemre/Manisa");

        driver.findElement(By.xpath("//*[text()='United States']")).click();
        driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Yunusemre");
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Manisa");
        driver.findElement(By.cssSelector("input[name='zipcode']")).sendKeys("45110");
        driver.findElement(By.cssSelector("input[name='mobile_number']")).sendKeys("05522365370");
        Thread.sleep(3000);

        WebElement createAccount = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        createAccount.submit();
        Thread.sleep(5000);

    }

    @Test
    public void test05() throws InterruptedException {
        String actualText = driver.findElement(By.xpath("//*[text()='Account Created!']")).getText();
        String expectedText = "ACCOUNT CREATED!";
        Assert.assertTrue(actualText.contains(expectedText));
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        WebElement addCloser = driver.findElement(By.cssSelector("span[class='ns-ys8ts-e-21']"));
        driver.navigate().refresh();
        addCloser.click();
        Thread.sleep(3000);

        String actualUsernameLogged = driver.findElement(By.cssSelector("i[class='fa fa-user']")).getText();
        String expectedUsernameLogged = "Lawsted";

        Assert.assertTrue(actualUsernameLogged.contains(expectedUsernameLogged));
        Thread.sleep(3000);


    }

    @Test
    @Ignore
    public void test06() {
        driver.findElement(By.cssSelector("i[class='fa fa-trash-o']")).click();


        String actualText = driver.findElement(By.xpath("//*[text()='Account Deleted!']")).getText();
        String expectedText = "ACCOUNT DELETED!";

        Assert.assertTrue(actualText.contains(expectedText));

    }


}
