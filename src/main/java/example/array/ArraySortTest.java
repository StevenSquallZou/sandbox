package example.array;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;


@Slf4j
public class ArraySortTest {

    @Test
    public void sort() {
        int[] array = {5, 3, 6, 4, 2, 1};
        Arrays.sort(array);
        log.info("sorted array: {}", array);
    }


    /**
     * first convert int[] to Integer[]
     * then use Arrays.sort() with Collections.reverseOrder()
     */
    @Test
    public void descendingSort1() {
        int[] array = {5, 3, 6, 4, 2, 1};
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, Collections.reverseOrder());
        log.info("descending sorted array1: {}", Arrays.toString(integerArray));
    }


    @Test
    public void descendingSort2() {
        int[] array = {5, 3, 6, 4, 2, 1};
        int[] descendingArray = Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        log.info("descending sorted array2: {}", descendingArray);
    }

}