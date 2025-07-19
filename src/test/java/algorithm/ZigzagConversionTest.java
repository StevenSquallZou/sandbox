package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ZigzagConversionTest {
    private ZigzagConversion solution;


    @BeforeEach
    void setUp() {
        solution = new ZigzagConversion();
    }


    @Test
    void testConvert1() {
        // arrange
        String str = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";

        // act
        String actual = solution.convert(str, numRows);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testConvert2() {
        // arrange
        String str = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";

        // act
        String actual = solution.convert(str, numRows);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testConvert3() {
        // arrange
        String str = "A";
        int numRows = 1;
        String expected = "A";

        // act
        String actual = solution.convert(str, numRows);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testConvert4() {
        // arrange
        String str = "AB";
        int numRows = 1;
        String expected = "AB";

        // act
        String actual = solution.convert(str, numRows);

        // assert
        assertEquals(expected, actual);
    }

}