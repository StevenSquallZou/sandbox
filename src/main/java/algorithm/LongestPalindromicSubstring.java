package algorithm;


/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int longestLeft = 0;
        int longestRight = 0;

        // single letter must be a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // two consecutive same letters must be a palindrome
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                longestLeft = i;
                longestRight = i + 1;
            }
        }

        // if s[i] == s[j] and the substring i + 1, j - 1 is a palindrome,
        // then the substring i, j must also be a palindrome.
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    longestLeft = i;
                    longestRight = j;
                }
            }
        }

        return s.substring(longestLeft, longestRight + 1);
    }

}
