package algorithm;


import java.util.Arrays;


/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Example 1:
 *     Input: x = 123
 *     Output: 321
 * Example 2:
 *     Input: x = -123
 *     Output: -321
 * Example 3:
 *     Input: x = 120
 *     Output: 21
 * Constraints:
 *     -2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = false;

        if (x == Integer.MIN_VALUE) {
            return 0;
        } else if (x < 0) {
            x = -x;
            isNegative = true;
            System.out.println("reversed x: " + x);
        } else {
            System.out.println("original x: " + x);
        }

        String str = String.valueOf(x);
        int n = str.length();
        char[] array = new char[n];

        for (int i = 0; i < n; i++) {
            array[n - i - 1] = str.charAt(i);
        }

        String reverseStr = new String(array);
        long l = Long.parseLong(reverseStr);
        if (l > Integer.MAX_VALUE) {
            return 0;
        }

        return isNegative ? -(int) l: (int) l;
    }

}
