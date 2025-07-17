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
    void testCalculateShortestLength1() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int expected = 2; // [4, 3]

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        assertEquals(expected, actual);
    }


    @Test
    void testCalculateShortestLength2() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 8;
        int expected = 3; // [2, 4, 3]

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        assertEquals(expected, actual);
    }


    @Test
    void testCalculateShortestLength3() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 9;
        int expected = 3; // [2, 4, 3]

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        assertEquals(expected, actual);
    }


    @Test
    void testCalculateShortestLength4() {
        // arrange
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 10;
        int expected = 4; // [3, 1, 2, 4] or [1, 2, 4, 3]

        // act
        int actual = shortestLengthSumGreaterThanTarget.calculateShortestLength(array, target);

        // asset
        assertEquals(expected, actual);
    }


    @Test
    void testCalculateShortestLength5() {
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
    void testCalculateShortestLength6() {
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
    void testCalculateShortestLength7() {
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