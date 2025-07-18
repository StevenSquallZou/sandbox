package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class DecodeWaysTest {
    private DecodeWays solution;


    @BeforeEach
    void setUp() {
        solution = new DecodeWays();
    }


    @Test
    void numDecodings1() {
        // arrange
        String str = "12";
        int expected = 2;

        // act
        int actual = solution.numDecodings(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void numDecodings2() {
        // arrange
        String str = "226";
        int expected = 3;

        // act
        int actual = solution.numDecodings(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void numDecodings3() {
        // arrange
        String str = "06";
        int expected = 0;

        // act
        int actual = solution.numDecodings(str);

        // assert
        assertEquals(expected, actual);
    }

}