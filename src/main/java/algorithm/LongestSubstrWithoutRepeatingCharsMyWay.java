package algorithm;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个字符串string ，请你找出其中不含有重复字符的最长的长度。
 * abcabcbb, 最长字符串 abc, 长度 3
 * aaaaa，最长字符串a, 长度 1
 * addbcd, 最长字符串dbc, 长度3
 */
@Slf4j
public class LongestSubstrWithoutRepeatingCharsMyWay {

    public int check(String str) {
        log.info("str: {}", str);

        if (StringUtils.isBlank(str)) {
            return 0;
        }

        int maxLength = 0;
        Map<Character, Integer> charIdxMap = new HashMap<>();
        int n = str.length();
        int leftIdx = 0;
        int rightIdx = 0;

        while (rightIdx < n) {
            char c = str.charAt(rightIdx);
            Integer charIdx = charIdxMap.get(c);
            log.info("leftIdx={}, rightIdx={}, {}", leftIdx, rightIdx, c + ": " + charIdx);

            if (charIdx == null || charIdx < leftIdx) {
                maxLength = Math.max(maxLength, rightIdx - leftIdx + 1);
                log.info("maxLength={}", maxLength);
            } else {
                leftIdx = charIdx + 1;
                log.info("moving leftIdx to {}", leftIdx);
            }

            charIdxMap.put(c, rightIdx);

            rightIdx++;
            log.info("moving rightIdx to {}", rightIdx);
        }

        return maxLength;
    }

}