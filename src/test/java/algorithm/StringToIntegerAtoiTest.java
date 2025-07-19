package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StringToIntegerAtoiTest {
    private StringToIntegerAtoi solution;


    @BeforeEach
    void setUp() {
//        solution = new StringToIntegerAtoi();
        solution = new StringToIntegerAtoiAnswer();
    }


    @Test
    void testMyAtoi1() {
        // arrange
        String str = "42";
        int expected = 42;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi2() {
        // arrange
        String str = " -042";
        int expected = -42;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi3() {
        // arrange
        String str = " 1337c0d3";
        int expected = 1337;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi4() {
        // arrange
        String str = " 0-1";
        int expected = 0;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi5() {
        // arrange
        String str = "words and 987";
        int expected = 0;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi6() {
        // arrange
        String str = "+-12";
        int expected = 0;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi7() {
        // arrange
        String str = "20000000000000000000";
        int expected = 2147483647;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi8() {
        // arrange
        String str = "  0000000000012345678";
        int expected = 12345678;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi9() {
        // arrange
        String str = "2147483646";
        int expected = 2147483646;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi10() {
        // arrange
        String str = "-5-";
        int expected = -5;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMyAtoi11() {
        // arrange
        String str = "  +  413";
        int expected = 0;

        // act
        int actual = solution.myAtoi(str);

        // assert
        assertEquals(expected, actual);
    }

}