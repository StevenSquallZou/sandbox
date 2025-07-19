package example.integer;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class IntegerTest {

    public static void main(String[] args) {
        log.info("Started");


        log.info("Result: {}", (int)'0');
        log.info("Result: {}", (int)'9');
        log.info("Integer.MAX_VALUE: {}", Integer.MAX_VALUE); // 2147483647
        log.info("Integer.MIN_VALUE: {}", Integer.MIN_VALUE); // -2147483648
        log.info("Integer.MIN_VALUE + 1: {}", Integer.MIN_VALUE + 1);

        log.info("Ended");
    }

}