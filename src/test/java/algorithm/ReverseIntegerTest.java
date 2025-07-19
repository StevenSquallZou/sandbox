package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ReverseIntegerTest {
    private ReverseInteger solution;

    @BeforeEach
    void setUp() {
        solution = new ReverseInteger();
    }


    @Test
    void testReverse1() {
        // arrange
        int x = 123;
        int expected = 321;

        // act
        int actual = solution.reverse(x);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testReverse2() {
        // arrange
        int x = -123;
        int expected = -321;

        // act
        int actual = solution.reverse(x);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testReverse3() {
        // arrange
        int x = 120;
        int expected = 21;

        // act
        int actual = solution.reverse(x);

        // assert
        assertEquals(expected, actual);
    }


    /**
     *  reversed 2147483647 will be greater than Integer.MAX_VALUE
     */
    @Test
    void testReverse4() {
        // arrange
        int x = 2147483647;
        int expected = 0;

        // act
        int actual = solution.reverse(x);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testReverse5() {
        // arrange
        int x = -2147483648;
        int expected = 0;

        // act
        int actual = solution.reverse(x);

        // assert
        assertEquals(expected, actual);
    }

}