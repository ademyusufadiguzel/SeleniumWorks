import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase10 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void test1(){
        driver.get("https://automationexercise.com");
        Actions actions = new Actions(driver);

        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());

        WebElement pageEnd = driver.findElement(By.xpath("//div[@class='single-widget']//h2"));
        actions.moveToElement(pageEnd).perform();

        WebElement pageEndText = driver.findElement(By.xpath("//div[@class='single-widget']//h2"));
        Assert.assertTrue(pageEndText.isDisplayed());

        driver.findElement(By.id("susbscribe_email")).sendKeys("adiguzelademyusuf3@gmail.com");
        waitFor(1);
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();
        waitFor(1);

        WebElement successMessage = driver.findElement(By.id("success-subscribe"));
        Assert.assertTrue(successMessage.isDisplayed());

        waitFor(5);
    }
}
