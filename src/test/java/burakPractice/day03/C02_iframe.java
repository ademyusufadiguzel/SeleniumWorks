package burakPractice.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C02_iframe extends TestBase {

    // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
    // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
    // TextBox'a 'Merhaba Dunya' yazin.
    // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement text = driver.findElement(By.xpath("//div[@class='example']//h3"));
        System.out.println(text.getText());
        Assert.assertTrue(text.isEnabled());

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Hello World");

        driver.switchTo().defaultContent();

        WebElement linkText = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkText.isDisplayed());
        System.out.println(linkText.getText());

        waitFor(5);


    }

}
