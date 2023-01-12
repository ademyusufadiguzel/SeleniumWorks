package burakPractice.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C02_FIleDownload extends TestBase {

    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. some-file.txt dosyasini indirelim
    //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("some-file.txt")).click();
        waitFor(3);

        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);

        String downloadsPath = System.getProperty("user.home")+"/Downloads";
        boolean isExist = Files.exists(Path.of(downloadsPath+"/some-file.txt"));
        System.out.println(downloadsPath+"/some-file.txt");

        Assert.assertTrue(isExist);
    }
}