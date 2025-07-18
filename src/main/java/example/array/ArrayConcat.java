package example.array;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;


@Slf4j
public class ArrayConcat {

    @Test
    public void concatArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        int[] concattedNums = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).toArray();
        log.info("concattedNums: {}", concattedNums);
    }


    @Test
    public void concatArraysAndSort() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        int[] concattedNums = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().toArray();
        log.info("sorted concattedNums: {}", concattedNums);
    }

}
