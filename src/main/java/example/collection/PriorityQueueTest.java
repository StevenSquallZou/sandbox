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

}
