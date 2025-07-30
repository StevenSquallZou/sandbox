package algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import algorithm.CycledNodeListChecker.ListNode;
import static org.junit.jupiter.api.Assertions.*;


class CycledNodeListCheckerTest {
    private CycledNodeListChecker solution;


    @BeforeEach
    void setUp() {
        solution = new CycledNodeListChecker();
    }


    @Test
    void checkIfCycledNodeList1() {
        // arrange
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        boolean expected = false;

        // act
        boolean actual = solution.checkIfCycledNodeList(node1);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void checkIfCycledNodeList2() {
        // arrange
        // 1 -> 2 -> 3 -> 4 -> 2 -> 3 -> 4 -> 2...
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node4.next = node2;

        boolean expected = true;

        // act
        boolean actual = solution.checkIfCycledNodeList(node1);

        // assert
        assertEquals(expected, actual);
    }

}