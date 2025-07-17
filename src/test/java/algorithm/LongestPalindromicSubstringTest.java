package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring longestPalindromicSubstring;


    @BeforeEach
    void setUp() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }


    @Test
    void longestPalindrome1() {
        String actual = longestPalindromicSubstring.longestPalindrome("babad");
        String expected1 = "bab";
        String expected2 = "aba";

        assertTrue(expected1.equals(actual) || expected2.equals(actual));
    }


    @Test
    void longestPalindrome2() {
        String actual = longestPalindromicSubstring.longestPalindrome("cbbd");
        String expected = "bb";

        assertEquals(expected, actual);
    }

}