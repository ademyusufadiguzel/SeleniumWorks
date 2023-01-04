import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TestCase06 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationexercise.com");

        WebElement pageVisiable = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(pageVisiable.isDisplayed());

        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        String pageTitleText = driver.findElement(By.xpath("//div[@class='contact-form']//h2")).getText();
        Assert.assertEquals("GET IN TOUCH", pageTitleText);

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Lawsted", Keys.TAB, "adiguzelademyusuf@gmail.com", Keys.TAB, "Selenium", Keys.TAB, "Hi automation exercise website");

        driver.findElement(By.xpath("//input[@name='upload_file']")).submit();

        driver.switchTo().alert().accept();

        String success = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.", success);

        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();

        Thread.sleep(30000);

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com", url);
    }
}