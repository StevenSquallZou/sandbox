package algorithm.template;


import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;


@Slf4j
public class AlternateSort {

    public static void main(String[] args) {
        log.info("Started");

        String s = "zou";
        log.info("Result: {}", s.charAt(0));

        log.info("Ended");
    }


    public static int[] alternateSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        Arrays.sort(arr);
        int n = arr.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = arr[left++];
            } else {
                result[i] = arr[right--];
            }
        }

        return result;
    }
}
