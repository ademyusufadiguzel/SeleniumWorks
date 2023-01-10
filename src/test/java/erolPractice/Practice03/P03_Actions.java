package erolPractice.Practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {

    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
    Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.

     */


    //http://uitestpractice.com/Students/Actions adresine gidelim
    //Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
    //Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
    //Accept ile alert'ü kapatalım
    //Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin


    @Test
    public void test1(){
        driver.get("http://uitestpractice.com/Students/Actions");
        Actions actions = new Actions(driver);

        WebElement blueBoxSelect = driver.findElement(By.id("div2"));
        actions.moveToElement(blueBoxSelect).perform();
        waitFor(3);

        WebElement doubleClickBox = driver.findElement(By.xpath("//button[@name='dblClick']"));
        actions.doubleClick(doubleClickBox).perform();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();

        WebElement dragBox = driver.findElement(By.id("draggable"));
        WebElement dropBox = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(dragBox,dropBox).perform();

        Assert.assertEquals("Dropped!", dropBox.getText());




    }

}
