package example.character;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CharacterTest {

    public static void main(String[] args) {
        log.info("Started");

        log.info("is digit: {}", Character.isDigit('0'));
        log.info("is digit: {}", Character.isDigit('a'));

        log.info("Ended");
    }

}