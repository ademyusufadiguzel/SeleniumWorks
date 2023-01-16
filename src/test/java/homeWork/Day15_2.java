package homeWork;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Random;

public class Day15_2 extends TestBase {

    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım

    @Test
    public void test1(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        Faker faker = new Faker();
        List<WebElement> calculateKeys = driver.findElements(By.xpath("//span[@class='operator btn btn-outline-success']"));

        String number1First = String.valueOf(faker.number().numberBetween(1,9));
        String number1Second = String.valueOf(faker.number().numberBetween(0,9));

        String number2First = String.valueOf(faker.number().numberBetween(1,9));
        String number2Second = String.valueOf(faker.number().numberBetween(0,9));

        double sayi1Double = Double.parseDouble(number1First+number1Second);
        double sayi2Double = Double.parseDouble(number2First+number2Second);

        driver.findElement(By.xpath("//div[@class='keys']//span[.='"+number1First+"']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//div[@class='keys']//span[.='"+number1Second+"']")).click();
        waitFor(1);

        WebElement keys = calculateKeys.get(faker.number().numberBetween(0,4));
        keys.click();

        driver.findElement(By.xpath("//div[@class='keys']//span[.='"+number2First+"']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//div[@class='keys']//span[.='"+number2Second+"']")).click();
        waitFor(1);

        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']")).click();
        waitFor(10);

        String result = driver.findElement(By.xpath("//div[@class='screen']")).getText();
        double doubleResult = Double.parseDouble(result);

        double expected = 0;
        if (keys.getText().contains("+")){
            expected = sayi1Double+sayi2Double;
        } else if (keys.getText().contains("-")) {
            expected = sayi1Double-sayi2Double;
        } else if (keys.getText().contains("x")) {
            expected = sayi1Double*sayi2Double;
        }else if (keys.getText().contains("÷")){
            expected = sayi1Double/sayi2Double;
        }

        System.out.println(doubleResult);
        System.out.println(expected);

        Assert.assertTrue(expected==doubleResult);
    }
}