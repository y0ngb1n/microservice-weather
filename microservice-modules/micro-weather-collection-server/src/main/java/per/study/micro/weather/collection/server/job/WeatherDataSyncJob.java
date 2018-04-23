package per.study.micro.weather.collection.server.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import per.study.micro.weather.collection.server.service.DataClient;
import per.study.micro.weather.collection.server.service.WeatherDataCollectionService;
import per.study.micro.weather.collection.server.vo.City;

import java.util.List;

/**
 * 定时同步天气数据.
 *
 * @author yangbin
 **/
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private DataClient dataClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.debug("【定时同步天气数据】定时任务！");

        // 1. 获取城市ID列表.
        List<City> cityList;
        try {
            cityList = dataClient.listCity();
        } catch (Exception e) {
            log.error("【定时同步天气数据】获取城市ID列表失败", e);
            throw new JobExecutionException(e);
        }

        // 2. 遍历城市ID获取天气数据.
        String cityId;
        for (City city : cityList) {
            cityId = city.getId();
            log.info("【定时同步天气数据】正在同步城市ID为{}的数据.", cityId);
            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        log.info("【定时同步天气数据】已全部同步完成！");
    }
}
