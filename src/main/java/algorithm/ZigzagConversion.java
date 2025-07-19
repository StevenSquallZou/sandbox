package algorithm;


import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *     P   A   H   N
 *     A P L S I I G
 *     Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *     string convert(string s, int numRows);
 * Example 1:
 *     Input: s = "PAYPALISHIRING", numRows = 3
 *     Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *     Input: s = "PAYPALISHIRING", numRows = 4
 *     Output: "PINALSIGYAHRPI"
 * Explanation:
 *     P     I    N
 *     A   L S  I G
 *     Y A   H R
 *     P     I
 * Example 3:
 *     Input: s = "A", numRows = 1
 *     Output: "A"
 * Constraints:
 *     1 <= s.length <= 1000
 *     s consists of English letters (lower-case and upper-case), ',' and '.'.
 *     1 <= numRows <= 1000
 */
@Slf4j
public class ZigzagConversion {

    public String convert(String s, int numRows) {
//        log.info("s: {}, numRows: {}", s, numRows);

        if (numRows == 1) {
            return s;
        }

        // initialize the rowMap
        Map<Integer, List<Character>> rowMap = new LinkedHashMap<>();
        for (int i = 0; i < numRows; i++) {
            rowMap.put(i, new ArrayList<>());
        }

        // fill the rowMap
        int currentRow = 0;
        boolean direction = true; // true: top-to-bottom; false: bottom-to-top
        for (int i = 0; i < s.length(); i++) {
            rowMap.get(currentRow).add(s.charAt(i));

            if (direction) { // top-down
                currentRow++;

                if (currentRow >= (numRows - 1)) {
                    direction = false; // turn direction to bottom-to-top
                }
            } else { // bottom-up
                currentRow--;

                if (currentRow <= 0) {
                    direction = true; // turn direction to top-to-bottom
                }
            }
        }

        // construct the result string
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : rowMap.values()) {
            for (Character c : list) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
