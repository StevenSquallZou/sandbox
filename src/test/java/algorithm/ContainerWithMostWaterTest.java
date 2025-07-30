package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ContainerWithMostWaterTest {
    private ContainerWithMostWater solution;


    @BeforeEach
    void setUp() {
        solution = new ContainerWithMostWater();
    }


    @Test
    void testMaxArea1() {
        // arrange
        int[] heightArray = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;

        // act
        int actual = solution.maxArea(heightArray);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testMaxArea2() {
        // arrange
        int[] heightArray = {1, 1};
        int expected = 1;

        // act
        int actual = solution.maxArea(heightArray);

        // assert
        assertEquals(expected, actual);
    }

}