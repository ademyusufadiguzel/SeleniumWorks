package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08 extends TestBase {

    //go to url :http://demo.automationtesting.in/Alerts.html
    //click  "Alert with OK" and click 'click the button to display an alert box:'
    //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
    //accept Alert(I am an alert box!) and print alert on console
    //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
    //click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
    //cancel Alert  (Press a Button !)
    //Alert'ü kapatın
    //click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
    //and then sendKeys 'TechProEducation' (Please enter your name)
    //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
    //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
    //finally print on console this mesaaje "Hello TechproEducation How are you today"

    @Test
    public void test1() {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        String alertMessage1 = driver.switchTo().alert().getText();
        System.out.println(alertMessage1);
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        driver.switchTo().alert().sendKeys("Adem Yusuf Adiguzel");
        driver.switchTo().alert().accept();
        String message = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        Assert.assertTrue(message.contains("Adem Yusuf Adiguzel"));
        System.out.println(message);
    }
}