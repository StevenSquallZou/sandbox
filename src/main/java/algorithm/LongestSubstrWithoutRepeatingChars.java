package algorithm;


import java.util.Arrays;


/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">...</a>
 * Given a string s, find the length of the longest substring without duplicate characters.
 * Example 1:
 *     Input: s = "abcabcbb"
 *     Output: 3
 *     Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *     Input: s = "bbbbb"
 *     Output: 1
 *     Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *     Input: s = "pwwkew"
 *     Output: 3
 *     Explanation: The answer is "wke", with the length of 3.
 *     Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Constraints:
 *     0 <= s.length <= 5 * 104
 *     s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstrWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        char[] charArray = s.toCharArray();
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);

        for (int right = 0; right < charArray.length; right++) {
            char currentChar = charArray[right];
            int currentCharInt = currentChar;

            if (charIndex[currentCharInt] == -1 || charIndex[currentCharInt] < left) { // this char has never appeared, or visited but outside the sliding window
                maxLength = Math.max(maxLength, right - left + 1); // update the max length
            } else { // this char once appeared
                left = charIndex[currentCharInt] + 1; // move the left of the sliding window to the next of the last index of the same last occurred char
                // no need to re-calculate maxLength here because the number of the elements in the sliding window are reduced or NOT changed
            }

            charIndex[currentCharInt] = right; // record the index of current char
        }

        return maxLength;
    }

}
