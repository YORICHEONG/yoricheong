package YoRiCheong.task;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/12/30 17:26
 * @Tags
 **/
@Component
@Slf4j
public class AsyncTask {

    @SneakyThrows
    @Async("asyncThreadPoolTaskExecutor")
    public void doTask() {
        long t1 = System.currentTimeMillis();
        Thread.sleep(1000);
        long t2 = System.currentTimeMillis();
        log.info("task1 cost {} ms" , t2-t1);
    }

    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        new AsyncTask().doTask();
        long t2 = System.currentTimeMillis();
        log.info("main cost {} ms" , t2-t1);
    }

}
