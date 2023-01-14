package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day15 extends TestBase {

    //https://www.way2automation.com/angularjs-protractor/webtables/
    //tüm E-mail leri yazdırın
    //Tüm E-maillerin "@" işareti içerdiğini doğrulayin

    @Test
    public void test(){
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr//td[7]"));
        elements.forEach(t -> System.out.println(t.getText()));

        for (WebElement w : elements){
            Assert.assertTrue(w.getText().contains("@"));
        }
    }

//    public static String elementsToTextString(List<WebElement> elements) {
//         return elements.forEach(t -> System.out.println(t.getText()));
//
//    }

}
