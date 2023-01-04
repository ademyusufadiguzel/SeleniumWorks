import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class TestCase05 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and already registered email address
    //7. Click 'Signup' button
    //8. Verify error 'Email Address already exist!' is visible

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
        WebElement pageVisible = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(pageVisible.isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        String newUserText = driver.findElement(By.xpath("//div[@class='signup-form']//h2")).getText();
        Assert.assertEquals("New User Signup!", newUserText);

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Lawsted", Keys.TAB, "adiguzelademyusuf@gmail.com", Keys.TAB, Keys.ENTER);

        String existText = driver.findElement(By.xpath("//form[@action='/signup']//p")).getText();
        Assert.assertEquals("Email Address already exist!", existText);

    }

}
