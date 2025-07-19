package algorithm;


import java.util.Stack;


/**
 * <a href="https://leetcode.cn/problems/string-to-integer-atoi/description/">...</a>
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * The algorithm for myAtoi(string s) is as follows:
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * Example 1:
 *     Input: s = "42"
 *     Output: 42
 * Explanation:
 *     The underlined characters are what is read in and the caret is the current reader position.
 *     Step 1: "42" (no characters read because there is no leading whitespace)
 *              ^
 *     Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *              ^
 *     Step 3: "42" ("42" is read in)
 *            ^
 * Example 2:
 *     Input: s = " -042"
 *     Output: -42
 * Explanation:
 *     Step 1: "   -042" (leading whitespace is read and ignored)
 *                 ^
 *     Step 2: "   -042" ('-' is read, so the result should be negative)
 *                  ^
 *     Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
 *                    ^
 * Example 3:
 *     Input: s = "1337c0d3"
 *     Output: 1337
 * Explanation:
 *     Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
 *              ^
 *     Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
 *              ^
 *     Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
 *                  ^
 * Example 4:
 *     Input: s = "0-1"
 *     Output: 0
 *     Explanation:
 *         Step 1: "0-1" (no characters read because there is no leading whitespace)
 *                  ^
 *         Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
 *                  ^
 *         Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
 *                   ^
 * Example 5:
 *     Input: s = "words and 987"
 *     Output: 0
 *     Explanation:
 *         Reading stops at the first non-digit character 'w'.
 * Constraints:
 *     0 <= s.length <= 200
 *     s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        System.out.println("input s: " + s);
        int n = s.length();

        // get wanted digits
        Boolean isNegative = null;
        boolean signDigitStarted = false; // indicates whether digits start, non-digits are NOT allowed anymore
        boolean non0DigitStarted = false;
        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (isNegative != null && (c == '+' || c == '-') && !signDigitStarted) {
                System.out.println("isNegative already has value but encountered sign again: " + c);
                return 0;
            }

            int ascii = c;

            if (ascii == 48) { // 0
                signDigitStarted = true;

                if (!non0DigitStarted) {
                    continue;
                }
            } else if (ascii >= 49 && ascii <= 57) { // 1~9
                signDigitStarted = true;
                non0DigitStarted = true;
            } else { // non-digits
                if (signDigitStarted) {
                    break;
                } else {
                    if (c == ' ') {
                        continue;
                    } else if (c == '+') {
                        isNegative = false;
                        signDigitStarted = true;
                        continue;
                    } else if (c == '-') {
                        isNegative = true;
                        signDigitStarted = true;
                        continue;
                    } else {
                        System.out.println("non-digit encountered: " + c);
                        break;
                    }
                }
            }

            int digit = ascii - 48;

            integerStack.add(digit);
        }
        System.out.println("integerStack: {}" + integerStack);


        // join digits to convert to int
        if (integerStack.isEmpty()) {
            System.out.println("integerStack is empty, return 0");
            return 0;
        } else if (integerStack.size() > 10) { // exceeds Integer.MAX_VALUE or Integer.MIN_VALUE digits count
            if (Boolean.TRUE.equals(isNegative)) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int result = integerStack.pop();
        System.out.println("isNegative: " + isNegative);
        if (Boolean.TRUE.equals(isNegative)) {
            result = -result;
        }
        System.out.println("First result: " + result);

        int iTen = 0;
        while (!integerStack.isEmpty()) {
/*            if (iTen >= 8 && result > 0) { // exceeds Integer.MAX_VALUE or Integer.MIN_VALUE digits count
                System.out.println("iTen >= 8 and result > 0, return 0");
                return 0;
            }*/
            iTen++;
            Integer digit = integerStack.pop();
            System.out.println("digit: " + digit);
            if (Boolean.TRUE.equals(isNegative)) {
                digit = -digit;
            }

            long l = digit * (long) Math.pow(10L, iTen) + result;
            if (l > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (l < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            result = (int) l;
            System.out.println("digit: " + digit + ", iTen: " + iTen + ", result: " + result);
        }

        return result;
    }

}
