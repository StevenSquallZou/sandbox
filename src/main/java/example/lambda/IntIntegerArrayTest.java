package example.lambda;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.stream.IntStream;


@Slf4j
public class IntIntegerArrayTest {

    @Test
    void testIntArrayToIntegerArray() {
        int[] array = {5, 3, 6, 4, 2, 1};
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        log.info("integerArray: {}", Arrays.toString(integerArray));
    }


    @Test
    void testIntArrayToIntegerArray2() {
        int[] array = {5, 3, 6, 4, 2, 1};
        Integer[] integerArray = IntStream.of(array).boxed().toArray(Integer[]::new);

        log.info("integerArray: {}", Arrays.toString(integerArray));
    }


    @Test
    void testIntegerArrayToIntArray() {
        int[] array = {5, 3, 6, 4, 2, 1};
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        int[] intArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();

        log.info("intArray: {}", intArray);
    }

}
