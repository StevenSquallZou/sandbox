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
        boolean actual = balancedBracketChecker.checkBracketBalanced("(){}[]");

        assertTrue(actual);
    }

    /**
     * (({{))}} - balanced
     */
    @Test
    void testCheckBracketBalanced2() {
        boolean actual = balancedBracketChecker.checkBracketBalanced("(({{))}}");

        assertTrue(actual);
    }


    /**
     * ({) - unbalanced
     */
    @Test
    void testCheckBracketBalanced3() {
        boolean actual = balancedBracketChecker.checkBracketBalanced("({)");

        assertFalse(actual);
    }


    /**
     * (}) - unbalanced
     */
    @Test
    void testCheckBracketBalanced4() {
        boolean actual = balancedBracketChecker.checkBracketBalanced("(})");

        assertFalse(actual);
    }

}