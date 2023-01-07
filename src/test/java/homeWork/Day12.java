package homeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.LinkedList;
import java.util.List;

public class Day12 extends TestBase {

    //  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    //  #Fill in capitals by country
    //  #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    //  #Ülkeye göre başkentleri doldurun

    @Test
    public void test1() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        for (int i = 1; i < 8; i++) {

            WebElement source = driver.findElement(By.id("box" + i));
            WebElement target = driver.findElement(By.id("box" + (100 + i)));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();
        }
    }
}