import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class TestCase05 extends TestBase {

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(homePage.isDisplayed());

        String singUP = driver.findElement(By.xpath("(//h2)[3]")).getText();
        String singUPexpected = "New User Signup!";
        Assert.assertEquals(singUPexpected, singUP);

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Lawsted", Keys.TAB, "adiguzelademyusuf@gmail.com", Keys.TAB, Keys.ENTER);

        String errorText = driver.findElement(By.xpath("(//p)[1]")).getText();
        Assert.assertEquals("Email Address already exist!", errorText);


    }

}
