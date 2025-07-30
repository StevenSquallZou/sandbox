package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RegularExpressionMatchingTest {
    private RegularExpressionMatching solution;


    @BeforeEach
    void setUp() {
        solution = new RegularExpressionMatching();
    }


    @Test
    void testIsMatch1() {
        // arrange
        String s = "aa", p = "a";
        boolean expected = false;

        // act
        boolean actual = solution.isMatch(s, p);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testIsMatch2() {
        // arrange
        String s = "aa", p = "a*";
        boolean expected = true;

        // act
        boolean actual = solution.isMatch(s, p);

        // assert
        assertEquals(expected, actual);
    }

}