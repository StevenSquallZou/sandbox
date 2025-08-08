package example.collection;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;


@Slf4j
public class PriorityQueueTest {

    @Test
    public void testInteger() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);

        log.info("priorityQueue: {}", priorityQueue); // [1, 3, 2]
    }


    /**
     * get the top N nums from a given nums
     */
    @Test
    public void testGetTopNNums() {
        int[] nums = {3, 1, 2, 0, 9, 5, 8, 7, 6, 4};
        int topN = 7;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // put the first 7 nums into min heap first, the peak num must be the smallest one
        for (int i = 0; i < topN; i++) {
            priorityQueue.add(nums[i]);
        }

        for (int i = topN; i < nums.length; i++) {
            if (!priorityQueue.isEmpty() && nums[i] > priorityQueue.peek()) {
                priorityQueue.poll(); // remove the peak num
                priorityQueue.add(nums[i]); // insert the new num to the min heap
            }
        }

        log.info("priorityQueue: {}", priorityQueue); // [2, 3, 5, 8, 9, 7, 6]

        int[] sortedNNums = priorityQueue.stream().sorted().mapToInt(Integer::intValue).toArray();
        log.info("sortedNNums: {}", sortedNNums); // [2, 3, 5, 6, 7, 8, 9]
    }

}
