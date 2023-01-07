import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase08 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
        WebElement pageVisiable = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(pageVisiable.isDisplayed());

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        waitFor(2);

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/products", url);

        WebElement allProductsPage = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(allProductsPage.isDisplayed());

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='col-sm-4']//div[@class='product-image-wrapper']"));

        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        String url2 = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/product_details/1", url2);

        String productName = driver.findElement(By.xpath("//div[@class='product-information']//h2")).getText();
        System.out.println("Product Name : "+productName);

        String []productCategory = driver.findElement(By.xpath("(//div[@class='product-information']//p)[1]")).getText().split(" ");
        System.out.println("Product Category : "+productCategory[1]+" "+productCategory[2]+" "+productCategory[3]);

        String productPrice = driver.findElement(By.xpath("//span[.='Rs. 500']")).getText();
        System.out.println("Product Price : "+productPrice);

        String []productAvailability = driver.findElement(By.xpath("(//div[@class='product-information']//p)[2]")).getText().split(" ");
        System.out.println("Product Availability : "+productAvailability[1]+" "+productAvailability[2]);

        String []productCondition = driver.findElement(By.xpath("(//div[@class='product-information']//p)[3]")).getText().split(" ");
        System.out.println("Product Condition : "+productCondition[1]);

        String []productBrand = driver.findElement(By.xpath("(//div[@class='product-information']//p)[4]")).getText().split(" ");
        System.out.println("Product Brand : "+productBrand[1]);

    }

}
