import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase09 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//*"));
        Assert.assertTrue(homePage.isDisplayed());

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        waitFor(2);

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/products", url);

        driver.findElement(By.id("search_product")).sendKeys("Tshirt");
        driver.findElement(By.id("submit_search")).click();

        String productsText = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        Assert.assertEquals("SEARCHED PRODUCTS", productsText);

        WebElement productsSearch = driver.findElement(By.xpath("//div[@class='col-sm-4']//div[@class='productinfo text-center']//p"));
        Assert.assertTrue(productsSearch.isDisplayed());

    }

}
