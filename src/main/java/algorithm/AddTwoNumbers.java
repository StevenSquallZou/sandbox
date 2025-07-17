package algorithm;


/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/description/">...</a>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example 1:
 *     Input: l1 = [2,4,3], l2 = [5,6,4]
 *     Output: [7,0,8]
 *     Explanation: 342 + 465 = 807.
 * Example 2:
 *     Input: l1 = [0], l2 = [0]
 *     Output: [0]
 * Example 3:
 *     Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *     Output: [8,9,9,9,0,0,0,1]
 * Constraints:
 *     The number of nodes in each linked list is in the range [1, 100].
 *     0 <= Node.val <= 9
 *     It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumAllListNode = null;
        ListNode sumAllLastListNode = null;
        ListNode sumTwoListNode = null;
        Integer previousTenDigit = null;

        do {
            Object[] sumResult = addTwoNumbers(previousTenDigit, l1, l2);
            sumTwoListNode = (ListNode) sumResult[0];
            previousTenDigit = (Integer) sumResult[1];

            if (sumAllListNode == null) { // first node
                sumAllListNode = sumTwoListNode;
                sumAllLastListNode = sumAllListNode;
            } else {
                sumAllLastListNode.next = sumTwoListNode;
                sumAllLastListNode = sumTwoListNode;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null || (previousTenDigit != null && previousTenDigit > 0));

        return sumAllListNode;
    }


    public Object[] addTwoNumbers(Integer previousTenDigit, ListNode l1, ListNode l2) {
        int sum = 0;

        if (l1 != null) {
            sum = sum + l1.val;
        }

        if (l2 != null) {
            sum = sum + l2.val;
        }

        if (previousTenDigit != null && previousTenDigit > 0) {
            sum = sum + previousTenDigit;
        }

        int tenDigit = sum / 10;
        int unitDigit = sum % 10;
        ListNode sumTwoListNode = new ListNode(unitDigit, null);

        return new Object[]{sumTwoListNode, tenDigit};
    }


    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;


        ListNode() {
        }


        ListNode(int val) {
            this.val = val;
        }


        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
