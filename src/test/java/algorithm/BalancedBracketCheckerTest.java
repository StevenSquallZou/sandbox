package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BalancedBracketCheckerTest {
    private BalancedBracketChecker balancedBracketChecker;


    @BeforeEach
    void setUp() {
        balancedBracketChecker = new BalancedBracketChecker();
    }


    /**
     * (){}[] - balanced
     */
    @Test
    void testCheckBracketBalanced1() {
        // act
        boolean actual = balancedBracketChecker.checkBracketBalanced("(){}[]");

        // assert
        assertTrue(actual);
    }

    /**
     * (({{))}} - balanced
     */
    @Test
    void testCheckBracketBalanced2() {
        // act
        boolean actual = balancedBracketChecker.checkBracketBalanced("(({{))}}");

        // assert
        assertTrue(actual);
    }


    /**
     * ({) - unbalanced
     */
    @Test
    void testCheckBracketBalanced3() {
        // assert
        boolean actual = balancedBracketChecker.checkBracketBalanced("({)");

        // assert
        assertFalse(actual);
    }


    /**
     * (}) - unbalanced
     */
    @Test
    void testCheckBracketBalanced4() {
        // assert
        boolean actual = balancedBracketChecker.checkBracketBalanced("(})");

        // assert
        assertFalse(actual);
    }

}