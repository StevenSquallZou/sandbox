package example.collection;


import lombok.extern.slf4j.Slf4j;
import java.util.Stack;


@Slf4j
public class StackTest {

    public static void main(String[] args) {
        log.info("Started");

        Stack<Integer> integerStack = new Stack<>();
        integerStack.add(0);
        integerStack.add(1);
        integerStack.add(2);

        for (Integer i : integerStack) {
            log.info("Iteration Result: {}", i);
        }

        while (!integerStack.isEmpty()) {
            log.info("Stack Result: {}", integerStack.pop());
        }

        log.info("Ended");
    }

}