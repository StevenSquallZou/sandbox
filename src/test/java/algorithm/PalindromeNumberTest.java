package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PalindromeNumberTest {
    private PalindromeNumber solution;


    @BeforeEach
    void setUp() {
        solution = new PalindromeNumber();
    }


    @Test
    void testIsPalindrome1() {
        // arrange
        int x = 121;
        boolean expected = true;

        // act
        boolean actual = solution.isPalindrome(x);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testIsPalindrome2() {
        // arrange
        int x = -121;
        boolean expected = false;

        // act
        boolean actual = solution.isPalindrome(x);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testIsPalindrome3() {
        // arrange
        int x = 10;
        boolean expected = false;

        // act
        boolean actual = solution.isPalindrome(x);

        // assert
        assertEquals(expected, actual);
    }

}