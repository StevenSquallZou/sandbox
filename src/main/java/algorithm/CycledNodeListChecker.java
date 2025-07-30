package algorithm;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CycledNodeListChecker {

    public boolean checkIfCycledNodeList(ListNode head) {
        if (head == null) {
            return false;
        }

        // only 1 node in the node list
        if (head.next == null) {
            return true;
        }

        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while (fastNode != null) {
            if (slowNode == fastNode) {
                log.info("slowNode == fastNode, true");
                return true;
            }

            // slowNode moves 1 step
            slowNode = slowNode.next;

            // fastNode moves 2 steps
            fastNode = fastNode.next;
            if (fastNode == null) {
                log.info("fastNode doesn't have next, true");
                return false;
            }
            fastNode = fastNode.next;
        }

        log.info("all iterated, fastNode doesn't have next, false");

        return false;
    }


    static class ListNode {
        int value;
        ListNode next;


        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

}
