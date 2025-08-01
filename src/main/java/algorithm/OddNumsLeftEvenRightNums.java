package algorithm;


import lombok.extern.slf4j.Slf4j;
import java.util.stream.IntStream;


/**
 * {1, 5, 10, 11, 16}
 * put odd numbers to the left, put even nums to the right
 * result: {1, 5, 11, 10, 16}
 */
@Slf4j
public class OddNumsLeftEvenRightNums {

    public int[] apply(int[] array) {
/*      // way 1:
        int[] oddArray = IntStream.of(array).filter(i -> i % 2 != 0).toArray();
        int[] evenArray = IntStream.of(array).filter(i -> i % 2 == 0).toArray();
        return IntStream.concat(IntStream.of(oddArray), IntStream.of(evenArray)).toArray();
*/

        // way 2:
        return IntStream.of(array).boxed().sorted((o1, o2) -> {
            if ((o1 % 2 != 0 && o2 % 2 != 0) || (o1 % 2 == 0 && o2 % 2 == 0)) {
                return 0;
            } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        }).mapToInt(Integer::intValue).toArray();
    }

}
