import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase12 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Products' button
    //5. Hover over first product and click 'Add to cart'
    //6. Click 'Continue Shopping' button
    //7. Hover over second product and click 'Add to cart'
    //8. Click 'View Cart' button
    //9. Verify both products are added to Cart
    //10. Verify their prices, quantity and total price

    @Test
    public void test1() {
        driver.get("https://automationexercise.com");

        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[.=' Cart']")).click();

        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();


    }

}
