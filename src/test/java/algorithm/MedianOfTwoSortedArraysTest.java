package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MedianOfTwoSortedArraysTest {
    private MedianOfTwoSortedArrays solution;


    @BeforeEach
    void setUp() {
        solution = new MedianOfTwoSortedArrays();
    }


    @Test
    void testFindMedianSortedArrays1() {
        // arrange
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2D;

        // act
        double actual = solution.findMedianSortedArrays(nums1, nums2);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testFindMedianSortedArrays2() {
        // arrange
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5D;

        // act
        double actual = solution.findMedianSortedArrays(nums1, nums2);

        // assert
        assertEquals(expected, actual);
    }

}