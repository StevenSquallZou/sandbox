package example;


import lombok.extern.slf4j.Slf4j;
import java.util.Stack;


@Slf4j
public class MyTest {

    public static void main(String[] args) {
        log.info("Started");


        log.info("Result: {}", (int)'0');
        log.info("Result: {}", (int)'9');
        log.info("Result: {}", Integer.MAX_VALUE); // 2147483647
        log.info("Result: {}", Integer.MIN_VALUE); // -2147483648
        log.info("Result: {}", Integer.MIN_VALUE + 1);

        log.info("Ended");
    }

}