package algorithm;


import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
 *     Input: nums1 = [1,3], nums2 = [2]
 *     Output: 2.00000
 *     Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *     Input: nums1 = [1,2], nums2 = [3,4]
 *     Output: 2.50000
 *     Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Constraints:
 *     nums1.length == m
 *     nums2.length == n
 *     0 <= m <= 1000
 *     0 <= n <= 1000
 *     1 <= m + n <= 2000
 *     -106 <= nums1[i], nums2[i] <= 106
 */
@Slf4j
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedJoinedNums = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().toArray();
        log.info("sorted sortedJoinedNums: {}", sortedJoinedNums);

        int middleIdx = sortedJoinedNums.length / 2;
        log.info("middleIdx: {}", middleIdx);

        if (sortedJoinedNums.length % 2 == 0) {
            return (sortedJoinedNums[middleIdx - 1] + sortedJoinedNums[middleIdx]) / 2D;
        } else {
            return sortedJoinedNums[middleIdx];
        }
    }

}
