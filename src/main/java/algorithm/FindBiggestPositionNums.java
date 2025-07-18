package algorithm;


import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * (SCB OD coding test)
 * given an array of int
 * 5, 3, 2, 4, 1, 4
 * biggestPosition=2
 * return 4, 4
 */
@Slf4j
public class FindBiggestPositionNums {

    public int[] returnWantedIntArray(int[] array, int biggestPosition) {
        int[] sortedArray = Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        log.info("sortedArray: {}", sortedArray);

        List<Integer> intList = new ArrayList<>();
        int targetInt = sortedArray[biggestPosition - 1];
        intList.add(targetInt);

        for (int i = biggestPosition; i < sortedArray.length; i++) {
            if (targetInt == sortedArray[i]) {
                intList.add(sortedArray[i]);
            } else {
                break;
            }
        }

        return intList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        log.info("Started");

        int[] array = {5, 3, 2, 4, 1, 4};
        int biggestPosition = 2;

        FindBiggestPositionNums app = new FindBiggestPositionNums();
        int[] wantedArray = app.returnWantedIntArray(array, biggestPosition);
        log.info("wantedArray: {}", wantedArray);

        log.info("Ended");
    }

}