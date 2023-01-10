package erolPractice.Practice03;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookie extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.

     */

    //Techproeducation adresine gidiniz
    //Sayfadaki cookie lerin sayısını yazdırınız
    //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
    //Yeni bir cookie ekleyiniz
    //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
    //Oluşturduğumuz cookie'i silelim
    //Tüm cookieleri silelim


    @Test
    public void test01(){
        driver.get("https://techproeducation.com");
        waitFor(20);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Sayfadaki Cookie sayisi = "+cookies.size());

        for (Cookie w : cookies){
            System.out.println(w.getName()+" : "+w.getValue());

        }

        Cookie myCookie = new Cookie("siteyeGirdimXD", "dsfakhslkjdhfasdh");
        driver.manage().addCookie(myCookie);

        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("Sayfadaki Cookie sayisi = "+cookies2.size());

        for (Cookie w : cookies2){
            System.out.println(w.getName());
        }

        driver.manage().deleteCookie(myCookie);
        driver.manage().deleteAllCookies();
    }
}
