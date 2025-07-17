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
    void testLongestPalindrome1() {
        // arrange
        String expected1 = "bab";
        String expected2 = "aba";

        // act
        String actual = longestPalindromicSubstring.longestPalindrome("babad");

        // assert
        assertTrue(expected1.equals(actual) || expected2.equals(actual));
    }


    @Test
    void testLongestPalindrome2() {
        // arrange
        String expected = "bb";

        // act
        String actual = longestPalindromicSubstring.longestPalindrome("cbbd");

        // assert
        assertEquals(expected, actual);
    }

}