import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class FakerDeneme{

    @Test
    public void test1(){
    Faker faker = new Faker();
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardNumber());
    }

}
