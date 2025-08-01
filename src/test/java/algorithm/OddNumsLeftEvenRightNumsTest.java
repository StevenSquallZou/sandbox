package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class OddNumsLeftEvenRightNumsTest {
    private OddNumsLeftEvenRightNums solution;


    @BeforeEach
    void setUp() {
        solution = new OddNumsLeftEvenRightNums();
    }


    @Test
    void testApply1() {
        // arrange
        int[] array = {1, 5, 10, 11, 16};
        int[] expected = {1, 5, 11, 10, 16};

        // act
        int[] actual = solution.apply(array);

        // assert
        assertArrayEquals(expected, actual);
    }


    @Test
    void testApply2() {
        // arrange
        int[] array = {};
        int[] expected = {};

        // act
        int[] actual = solution.apply(array);

        // assert
        assertArrayEquals(expected, actual);
    }


    @Test
    void testApply3() {
        // arrange
        int[] array = {2, 1, 5, 10, 11, 16, 0, 3};
        int[] expected = {1, 5, 11, 3, 2, 10, 16, 0};

        // act
        int[] actual = solution.apply(array);

        // assert
        assertArrayEquals(expected, actual);
    }

}