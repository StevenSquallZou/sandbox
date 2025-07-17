package algorithm;


/**
 * 给定一个含有n个正整数得数组和一个正整数target，找出该数组中满足其和>=target的长度最小的连续子数组，并返回其长度。
 * 例如target=7，数组[2,3,1,2,4,3]输出2，子数组[4,3]是该条件下长度最小的子数组。
 */
public class ShortestLengthSumGreaterThanTarget {

    public int calculateShortestLength(int[] array, int target) {
        int n = array.length;

        // store the sum from i to j
        int[][] dp = new int[n][n];

        // the sum from i to i is just itself
        for (int i = 0; i < n; i++) {
            if (array[i] >= target) {
                return 1;
            }

            dp[i][i] = array[i];
        }

        // calculate the sum from i to i + 1
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = array[i] + array[i + 1];

            if (dp[i][i + 1] >= target) {
                return 2;
            }
        }

        // calculate the sum from i to i + diff
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                dp[i][j] = array[i] + dp[i + 1][j - 1] + array[j];

                if (dp[i][j] >= target) {
                    return diff + 1;
                }
            }
        }

        return -1;
    }

}
