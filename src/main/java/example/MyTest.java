package example;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MyTest {

    public static void main(String[] args) {
        log.info("Started");

        int i = 9 / 2;
        log.info("Result: {}", i);

        log.info("Ended");
    }

}