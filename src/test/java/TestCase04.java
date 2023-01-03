import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase04 extends TestBase {

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
        WebElement pageView = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(pageView.isDisplayed());

        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        driver.findElement(By.xpath("(//h2)[1]"));

        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("adiguzelademyusuf@gmail.com", Keys.TAB, "ADEMyusuf585.",Keys.ENTER);

        String actualLoggedUserText = driver.findElement(By.xpath("(//a)[11]")).getText();
        Assert.assertEquals("Logged in as Lawsted", actualLoggedUserText);

        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        String actual = driver.getCurrentUrl();
        String expected = "https://automationexercise.com/login";
        Assert.assertEquals(expected, actual);
    }
}