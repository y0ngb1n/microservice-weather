package com.study.demo.microservice.weather.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时同步天气数据.
 *
 * @author yangbin
 **/
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("【定时同步天气数据】定时任务！");
    }
}
