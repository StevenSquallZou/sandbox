package example.regex;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class RegexTest {

    @Test
    void test1() {
        String str = "";
        String pattern = "";

        // true
        boolean result = str.matches(pattern);

        log.info("result: {}", result);
    }


    @Test
    void test2() {
        String str = "";
        String pattern = ".";

        // false
        boolean result = str.matches(pattern);

        log.info("result: {}", result);
    }


    @Test
    void test3() {
        String str = "a";
        String pattern = ".";

        // true
        boolean result = str.matches(pattern);

        log.info("result: {}", result);
    }


    @Test
    void test4() {
        String str = "ab";
        String pattern = ".";

        // false
        boolean result = str.matches(pattern);

        log.info("result: {}", result);
    }

}
