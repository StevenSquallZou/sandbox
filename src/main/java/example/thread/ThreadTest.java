package example.thread;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.concurrent.FutureTask;


@Slf4j
public class ThreadTest {

    @Test
    public void testCallableTask() {
        log.info("testCallableTask started");

        CallableTask callableTask = new CallableTask("task1");
        FutureTask<String> futureTask = new FutureTask<>(callableTask);

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            log.info("joining thread...");
            thread.join();
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            Thread.currentThread().interrupt();
        }

        log.info("testCallableTask ended");
    }

}
