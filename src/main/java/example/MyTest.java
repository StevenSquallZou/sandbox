package example;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MyTest {

    public static void main(String[] args) {
        log.info("Started");

        log.info("Result: {}", Integer.MAX_VALUE + 1);
        log.info("Result: {}", Integer.MIN_VALUE);

        log.info("Ended");
    }

}