package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Day07 extends TestBase {


    /*
    1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
    2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
    3-Option3 ü seçin.
    4-Option3 ün seçili olduğunu doğrulayın.
    */
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement dropdownExam = driver.findElement(By.xpath("//div[@class='cen-right-align']"));
        Assert.assertTrue(dropdownExam.isDisplayed());

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select option = new Select(dropdown);
        option.selectByVisibleText("Option3");

        Thread.sleep(5000);

        String selectedOption = option.getFirstSelectedOption().getText();
        Assert.assertEquals("Option3", selectedOption);
    }
}
