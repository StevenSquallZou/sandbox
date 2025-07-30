package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LongestSubstringWithoutRepeatingCharactersMyWayTest {
    private LongestSubstrWithoutRepeatingCharsMyWay solution;


    @BeforeEach
    void setUp() {
        solution = new LongestSubstrWithoutRepeatingCharsMyWay();
    }


    @Test
    void testCheck1() {
        // arrange
        String str = "abcabcbb";
        int expected = 3;

        // act
        int actual = solution.check(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testCheck2() {
        // arrange
        String str = "aaaaa";
        int expected = 1;

        // act
        int actual = solution.check(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testCheck3() {
        // arrange
        String str = "addbcd";
        int expected = 3;

        // act
        int actual = solution.check(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testCheck4() {
        // arrange
        String str = "pwwkew";
        int expected = 3;

        // act
        int actual = solution.check(str);

        // assert
        assertEquals(expected, actual);
    }

}