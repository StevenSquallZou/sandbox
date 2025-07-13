package example.thread;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * If fewer than corePoolSize threads are running, creates a new thread.
 * If corePoolSize threads are busy, new tasks go to the queue.
 * If queue is full and pool < maxPoolSize, creates new threads.
 * If queue is full and pool = maxPoolSize, triggers rejection policy.
 */
@Slf4j
public class ThreadPoolTest {

    @Test
    public void testThreadPool() {
        log.info("testThreadPool started");

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(4);
        // if using unbounded blocking queue, it will cause maximumPoolSize NOT working, i.e. never create temporary thread
//        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();

        RejectedExecutionHandler rejectedExecutionHandler = getRejectedExecutionHandler();

        try (ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, // corePoolSize: Minimum threads to keep alive
                5, // maximumPoolSize: Maximum threads allowed
                5, // keepAliveTime: Time idle threads wait before terminating
                TimeUnit.SECONDS, // unit: Time unit for keepAliveTime
                blockingQueue, // workQueue: Queue for holding tasks before execution
                Executors.defaultThreadFactory(), // threadFactory: Creates new threads
                rejectedExecutionHandler // handler: Rejection policy for saturated pool
        )) {
            printThreadPoolStatus(threadPoolExecutor, blockingQueue);

            List<Future<?>> futureList = submitTasks(threadPoolExecutor, blockingQueue);
            threadPoolExecutor.shutdown();

            checkTaskStatus(futureList);

            threadPoolExecutor.shutdownNow();
        }

        log.info("testThreadPool ended");
    }


    private RejectedExecutionHandler getRejectedExecutionHandler() {
        // A handler for rejected tasks that throws a RejectedExecutionException. This is the default handler
        return new ThreadPoolExecutor.AbortPolicy();

        // A handler for rejected tasks that silently discards the rejected task.
//        return new ThreadPoolExecutor.DiscardPolicy();

        // Drops oldest queued task
//        return new ThreadPoolExecutor.DiscardOldestPolicy();

        // A handler for rejected tasks that runs the rejected task directly in the calling thread of the execute method,
        // unless the executor has been shut down, in which case the task is discarded.
//        return new ThreadPoolExecutor.CallerRunsPolicy();
    }


    private void printThreadPoolStatus(ThreadPoolExecutor threadPoolExecutor, BlockingQueue<Runnable> blockingQueue) {
        log.info("current thread pool size: {}", threadPoolExecutor.getPoolSize());
        log.info("current blocking queue size: {}", blockingQueue.size());
    }


    private List<Future<?>> submitTasks(ThreadPoolExecutor threadPoolExecutor, BlockingQueue<Runnable> blockingQueue) {
        final int taskSize = 20;
        List<Future<?>> futureList = new ArrayList<>(taskSize);

        for (int i = 0; i < taskSize; i++) {
            String taskId = "CallableTask" + i;

            try {
//            Future<?> future = threadPoolExecutor.submit(new RunnableTask("RunnableTask" + i));
                Future<?> future = threadPoolExecutor.submit(new CallableTask(taskId));
                log.info("taskId={} submitted", taskId);
                futureList.add(future);
            } catch (RejectedExecutionException e) {
                log.error("taskId={} rejected", taskId, e);
            }

            printThreadPoolStatus(threadPoolExecutor, blockingQueue);
        }

        return futureList;
    }


    private void checkTaskStatus(List<Future<?>> futureList) {
        for (int i = 0; i < futureList.size(); i++) {
            Future<?> future = futureList.get(i);

            try {
                log.info("TaskIndex{} getting future result", i);
                Object result = future.get(3, TimeUnit.SECONDS);// Wait for each task to complete
//                Object result = future.get();// Wait for each task to complete forever
                log.info("TaskIndex{} completed with result: {}", i, result);
            } catch (InterruptedException e) {
                log.error("TaskIndex{} interrupted", i, e);
                Thread.currentThread().interrupt(); // Restore the interrupted status
            } catch (ExecutionException e) {
                log.error("TaskIndex{} execution failed", i, e);
            } catch (TimeoutException e) {
                log.error("TaskIndex{} timeout, cancelling the task", i, e);
                future.cancel(true);
            }
        }
    }

}