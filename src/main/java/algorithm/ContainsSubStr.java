package algorithm;


import lombok.extern.slf4j.Slf4j;


/**
 * 3. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 *    Input: s = "abc", t = "ahbgdc"
 *    Output: true
 * Example 2:
 *    Input: s = "axc", t = "ahbgdc"
 *    Output: false
 */
@Slf4j
public class ContainsSubStr {

    public boolean containsSubStr(String s, String t) {
        int sIdx = 0;
        int tIdx = 0;

        while (sIdx < s.length() && tIdx < t.length()) {
            if (t.charAt(tIdx) == s.charAt(sIdx)) {
                sIdx++;
                tIdx++;
            } else {
                tIdx++;
            }
        }

        return sIdx == s.length();
    }

}