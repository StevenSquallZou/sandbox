package encryption.base64;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.Base64;


@Slf4j
public class Base64Utils {

    @Test
    void testEncode() {
        String encodedStr = Base64Utils.encode("test");

        log.info("encodedStr: {}", encodedStr);
    }


    @Test
    void testDecode() {
        String origStr = Base64Utils.decode("dGVzdA==");

        log.info("origStr: {}", origStr);
    }


    public static String encode(String origStr) {
        log.info("origStr: {}", origStr);

        return Base64.getEncoder().encodeToString(origStr.getBytes());
    }


    public static String decode(String encodedStr) {
        log.info("encodedStr: {}", encodedStr);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedStr);

        return new String(decodedBytes);
    }

}
