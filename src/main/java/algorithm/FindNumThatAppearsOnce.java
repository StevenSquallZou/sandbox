package algorithm;


/**
 * (Coding test from SCB outsourcing dispatch)
 * Given a integer array nums where all numbers appear twice except one which appears only one time.
 * Find the number which appears only once.
 * Note: No extra memory space should be used.
 * Input: [1,1,4,4,2,3,3,8,8]
 * Output: 2
 */
public class FindNumThatAppearsOnce {

    public int findNumThatAppearsOnce(int[] array) {
        int result = 0;

        for (int num : array) {
            result = result ^ num;
        }

        return result;
    }

}
