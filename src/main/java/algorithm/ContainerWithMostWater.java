package algorithm;


import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/">...</a>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * Example 1:
 *     Input: height = [1,8,6,2,5,4,8,3,7]
 *     Output: 49
 *     Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *     Input: height = [1,1]
 *     Output: 1
 * Constraints:
 *     n == height.length
 *     2 <= n <= 105
 *     0 <= height[i] <= 104
 */
@Slf4j
public class ContainerWithMostWater {

    public int maxArea(int[] heightArray) {
        int maxArea = 0;
        int leftIdx = 0;
        int rightIdx = heightArray.length - 1;

        while (leftIdx < rightIdx) {
            int leftHeight = heightArray[leftIdx];
            int rightHeight = heightArray[rightIdx];
            int currentArea = Math.min(leftHeight, rightHeight) * (rightIdx - leftIdx);
            maxArea = Math.max(maxArea, currentArea);

            if (leftHeight <= rightHeight) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }

        return maxArea;
    }

}
