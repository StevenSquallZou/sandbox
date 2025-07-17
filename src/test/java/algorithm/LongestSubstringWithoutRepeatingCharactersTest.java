package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters solution;


    @BeforeEach
    public void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }


    @Test
    void lengthOfLongestSubstring1() {
        // arrange
        String str = "abcabcbb";

        // act
        int actual = solution.lengthOfLongestSubstring(str);

        // assert
        int expected = 3;
        assertEquals(expected, actual);
    }


    @Test
    void lengthOfLongestSubstring2() {
        // arrange
        String str = "bbbbb";

        // act
        int actual = solution.lengthOfLongestSubstring(str);

        // assert
        int expected = 1;
        assertEquals(expected, actual);
    }


    @Test
    void lengthOfLongestSubstring3() {
        // arrange
        String str = "pwwkew";

        // act
        int actual = solution.lengthOfLongestSubstring(str);

        // assert
        int expected = 3;
        assertEquals(expected, actual);
    }

}