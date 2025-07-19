package example;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MyTest {

    public static void main(String[] args) {
        log.info("Started");

        Object result = null;
        log.info("Result: {}", result);

        log.info("Ended");
    }

}