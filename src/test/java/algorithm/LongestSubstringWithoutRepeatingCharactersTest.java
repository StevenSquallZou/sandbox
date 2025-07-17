package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters solution;


    @BeforeEach
    void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }


    @Test
    void testLengthOfLongestSubstring1() {
        // arrange
        String str = "abcabcbb";
        int expected = 3;

        // act
        int actual = solution.lengthOfLongestSubstring(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testLengthOfLongestSubstring2() {
        // arrange
        String str = "bbbbb";
        int expected = 1;

        // act
        int actual = solution.lengthOfLongestSubstring(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testLengthOfLongestSubstring3() {
        // arrange
        String str = "pwwkew";
        int expected = 3;

        // act
        int actual = solution.lengthOfLongestSubstring(str);

        // assert
        assertEquals(expected, actual);
    }

}