package algorithm;


import lombok.extern.slf4j.Slf4j;


/**
 * <a href="https://leetcode.cn/problems/regular-expression-matching/description/">...</a>
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Example 1:
 *     Input: s = "aa", p = "a"
 *     Output: false
 *     Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *     Input: s = "aa", p = "a*"
 *     Output: true
 *     Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *     Input: s = "ab", p = ".*"
 *     Output: true
 *     Explanation: ".*" means "zero or more (*) of any character (.)".
 * Constraints:
 *     1 <= s.length <= 20
 *     1 <= p.length <= 20
 *     s contains only lowercase English letters.
 *     p contains only lowercase English letters, '.', and '*'.
 *     It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
@Slf4j
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        log.info("s: {}, p: {}", s, p);

        if (".*".equals(p)) {
            return true;
        }

        int sIdx = 0;
        int pIdx = 0;
        int sLength = s.length();
        int pLength = p.length();

        while (sIdx < sLength && pIdx < pLength) {
            char sChar = s.charAt(sIdx);
            char pChar = p.charAt(pIdx);
            log.info("{}: {}, {}: {}, sLength: {}, pLength: {}", sIdx, sChar, pIdx, pChar, sLength, pLength);

            if (sChar == pChar || pChar == '.') {
                log.info("sChar == pChar || pChar == '.'");
                sIdx++;
                pIdx++;
            } else if (pChar == '*') {
                if (sChar == s.charAt(sIdx - 1)) { // "aa" or "aaa" matches "a*"
                    log.info("pChar == '*' && sChar == s.charAt(sIdx - 1)");
                    sIdx++;
                } else {
                    log.info("pChar == '*' && sChar != s.charAt(sIdx - 1)");
                    pIdx++; // "aab" ~ "a*b"
                }
            } else {
                log.info("sChar != pChar or don't match");
                return false;
            }
        }

        if (sIdx >= sLength && pIdx >= pLength - 1) {
            log.info("sIdx: {}, sLength: {}, pIdx: {}, pLength: {}, reached the end, return true", sIdx, sLength, pIdx, pLength);
            return true;
        } else {
            log.info("sIdx: {}, sLength: {}, pIdx: {}, pLength: {}, either sIdx or pIdx doesn't reach the end, return false", sIdx, sLength, pIdx, pLength);
            return false;
        }
    }

}
