package algorithm;


/**
 * <a href="https://leetcode.cn/problems/palindrome-number/">...</a>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * Example 1:
 *     Input: x = 121
 *     Output: true
 *     Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *     Input: x = -121
 *     Output: false
 *     Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *     Input: x = 10
 *     Output: false
 *     Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Constraints:
 *     -2^31 <= x <= 2^31 - 1
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);

        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(n - i - 1);

            if (c1 != c2) {
                return false;
            }
        }

        return true;
    }

}
