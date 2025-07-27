package example.thread;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MyThread extends Thread {
    private static final ThreadLocal<Long> threadLocal = ThreadLocal.withInitial(() -> 0L);


    @Override
    public void run() {
        threadLocal.set(Thread.currentThread().threadId());

        log.info("threadLocal: {}", threadLocal.get());

        // Clean up (important to avoid memory leaks in web apps)
        threadLocal.remove();
    }

}
