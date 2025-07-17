package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FindNumThatAppearsOnceTest {
    private FindNumThatAppearsOnce solution;


    @BeforeEach
    void setUp() {
        solution = new FindNumThatAppearsOnce();
    }


    @Test
    void testFindNumber() {
        // arrange
        int[] array = {1, 1, 4, 4, 2, 3, 3, 8, 8};
        int expected = 2;

        // act
        int actual = solution.findNumThatAppearsOnce(array);

        // assert
        assertEquals(expected, actual);
    }

}