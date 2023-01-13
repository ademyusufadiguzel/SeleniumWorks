import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase11 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Cart' button
    //5. Scroll down to footer
    //6. Verify text 'SUBSCRIPTION'
    //7. Enter email address in input and click arrow button
    //8. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void test1(){
        driver.get("https://automationexercise.com");

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[.=' Cart']")).click();
        waitFor(5);

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.tagName("h2")));

        WebElement subText = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(subText.isDisplayed());

        driver.findElement(By.id("susbscribe_email")).sendKeys("adiguzelademyusuf@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        waitFor(1);

        WebElement successSubText = driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(successSubText.isDisplayed());

    }
}