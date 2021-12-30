package YoRiCheong.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/12/30 17:19
 * @Tags
 **/
@EnableAsync
@Configuration
public class AsyncConfiguration {

    @Bean(name = "asyncThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数
        taskExecutor.setCorePoolSize(10);
        // 线程池最大线程数
        taskExecutor.setMaxPoolSize(100);
        // 缓存队列
        taskExecutor.setQueueCapacity(50);
        // 非核心线程空闲的时间
        taskExecutor.setKeepAliveSeconds(200);
        // 线程名称
        taskExecutor.setThreadNamePrefix("YoRiCheong-async");
        // 线程池的线程拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程池初始化
        taskExecutor.initialize();

        return taskExecutor;
    }
}
