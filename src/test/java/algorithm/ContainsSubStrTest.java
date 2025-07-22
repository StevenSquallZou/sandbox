package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ContainsSubStrTest {
    ContainsSubStr solution;


    @BeforeEach
    void setUp() {
        solution = new ContainsSubStr();
    }


    @Test
    void testContainsSubStr1() {
        // arrange
        String s = "abc";
        String t = "ahbgdc";
        boolean expected = true;

        // act
        boolean actual = solution.containsSubStr(s, t);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void testContainsSubStr2() {
        // arrange
        String s = "axc";
        String t = "ahbgdc";
        boolean expected = false;

        // act
        boolean actual = solution.containsSubStr(s, t);

        // assert
        assertEquals(expected, actual);
    }

}