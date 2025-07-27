package example.thread;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;


@Slf4j
public class ThreadTest {

    @Test
    void testCallableTask() {
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


    @Test
    void testThreadLocal() throws InterruptedException {
        log.info("testThreadLocal started");

        List<MyThread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            threadList.add(myThread);
        }

        for (MyThread thread : threadList) {
            thread.join();
        }

        log.info("testThreadLocal ended");
    }

}
