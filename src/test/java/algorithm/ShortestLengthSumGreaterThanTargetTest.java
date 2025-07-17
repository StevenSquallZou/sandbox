package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ShortestLengthSumGreaterThanTargetTest {
    private ShortestLengthSumGreaterThanTarget shortestLengthSumGreaterThanTarget;


    @BeforeEach
    void setUp() {
        shortestLengthSumGreaterThanTarget = new ShortestLengthSumGreaterThanTarget();
    }


    @Test
    void calculateShortestLength1() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 7;

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        int expected = 2; // [4, 3]
        assertEquals(expected, actual);
    }


    @Test
    void calculateShortestLength2() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 8;

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        int expected = 3; // [2, 4, 3]
        assertEquals(expected, actual);
    }


    @Test
    void calculateShortestLength3() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 9;

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        int expected = 3; // [2, 4, 3]
        assertEquals(expected, actual);
    }


    @Test
    void calculateShortestLength4() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 10;

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        int expected = 4; // [3, 1, 2, 4] or [1, 2, 4, 3]
        assertEquals(expected, actual);
    }


    @Test
    void calculateShortestLength5() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 15;

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        int expected = 6; // [2, 3, 1, 2, 4, 3]
        assertEquals(expected, actual);
    }


    @Test
    void calculateShortestLength6() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 1;

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        int expected = 1; // any single-element array
        assertEquals(expected, actual);
    }


    @Test
    void calculateShortestLength7() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 100;

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        int expected = -1; // not exist
        assertEquals(expected, actual);
    }

}