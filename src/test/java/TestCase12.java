import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        Actions actions = new Actions(driver);

        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        waitFor(1);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(1);


        WebElement fistProductimg = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
        actions.moveToElement(fistProductimg).click(driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]"))).perform();
        String firstProductPrice = driver.findElement(By.xpath("(//div[@class='single-products']//h2)[1]")).getText();
        waitFor(1);
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();

        WebElement secondProduct = driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]"));
        WebElement secondProductimg = driver.findElement(By.xpath("//img[@src='/get_product_picture/2']"));
        String secondProductPrice = driver.findElement(By.xpath("(//div[@class='single-products']//h2)[3]")).getText();
        secondProduct.click();
        waitFor(1);
        driver.findElement(By.xpath("//p[@class='text-center']//u")).click();

        WebElement bothProduct1 = driver.findElement(By.xpath("//img[@src='get_product_picture/1']"));
        WebElement bothProduct2 = driver.findElement(By.xpath("//img[@src='get_product_picture/2']"));

        Assert.assertEquals(fistProductimg, bothProduct1);
        Assert.assertEquals(secondProductimg, bothProduct2);

        String price1 = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]")).getText();
        String price2 = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]")).getText();

        Assert.assertEquals(firstProductPrice, price1);
        Assert.assertEquals(secondProductPrice, price2);

    }

}
