package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class JumpGameIITest {
    private JumpGameII solution;


    @BeforeEach
    void setUp() {
        solution = new JumpGameII();
    }


    @Test
    void testJump1() {
        // arrange
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;

        // act
        int actual = solution.jump(nums);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testJump2() {
        // arrange
        int[] nums = {2, 3, 0, 1, 4};
        int expected = 2;

        // act
        int actual = solution.jump(nums);

        // assert
        assertEquals(expected, actual);
    }

}