package example.thread;


import example.utils.MyUtils;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.Callable;


@Slf4j
public class CallableTask implements Callable<String> {
    protected String taskId;


    public CallableTask(String taskId) {
        this.taskId = taskId;
    }


    @Override
    public String call() throws Exception {
        log.info("taskId={} started", taskId);

        MyUtils.silentlySleep(5000L);

        log.info("taskId={} ended", taskId);

        return taskId + " success"; // Return a result for the Callable
    }

}
