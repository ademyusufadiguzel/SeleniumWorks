import com.google.j2objc.annotations.Weak;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase07 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Test Cases' button
    //5. Verify user is navigated to test cases page successfully

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
        WebElement pageVisiabel = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(pageVisiabel.isDisplayed());

        driver.findElement(By.xpath("//a[.=' Test Cases']")).click();

        WebElement tesCasePage = driver.findElement(By.id("form"));
        Assert.assertTrue(tesCasePage.isEnabled());

    }

}
