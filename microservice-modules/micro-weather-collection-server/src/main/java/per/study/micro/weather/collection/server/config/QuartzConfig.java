package per.study.micro.weather.collection.server.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import per.study.micro.weather.collection.server.job.WeatherDataSyncJob;

/**
 * Quartz Configuration.
 *
 * @author yangbin
 **/
@Configuration
public class QuartzConfig {
    /** 更新频率. **/
    private static final int JOB_TIME_SECONDS = 1800;

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weatherDataSyncJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(JOB_TIME_SECONDS).repeatForever();
        return TriggerBuilder.newTrigger()
                .forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
