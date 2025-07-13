package example.thread;


import example.utils.MyUtils;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class RunnableTask implements Runnable {
    protected String taskId;


    public RunnableTask(String taskId) {
        this.taskId = taskId;
    }


    @Override
    public void run() {
        log.info("taskId={}, started", taskId);

        MyUtils.silentlySleep(5000L);

        log.info("taskId={}, ended", taskId);
    }

}
