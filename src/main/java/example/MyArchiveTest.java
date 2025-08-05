package example;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.Random;


@Slf4j
public class MyArchiveTest {

    @Test
    public void testRandom() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            log.info("Random: {}", random.nextLong(10));
        }
    }

}