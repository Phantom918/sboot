package com.phantom.sboot.web.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务类
 */
@Component
public class ScheduleTask {

    private static Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    private int count = 0;

    @Scheduled(cron = "0 58 14 * * ?")// 秒 分钟 小时 天 月 星期几 年
    private void task1() {
        System.out.println("这里是定时任务...." + count++);
        logger.info("这里是定时任务log....{}", count);
    }
}
