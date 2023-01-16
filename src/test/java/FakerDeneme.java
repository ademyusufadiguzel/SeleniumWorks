import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class FakerDeneme{

    @Test
    public void test1(){
    Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            System.out.println(faker.number().numberBetween(1,3));
        }


    }

}
