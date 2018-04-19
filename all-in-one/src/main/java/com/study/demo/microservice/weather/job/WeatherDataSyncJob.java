package com.study.demo.microservice.weather.job;

import com.study.demo.microservice.weather.service.CityDataService;
import com.study.demo.microservice.weather.service.WeatherDataService;
import com.study.demo.microservice.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 定时同步天气数据.
 *
 * @author yangbin
 **/
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("【定时同步天气数据】定时任务！");

        // 1. 获取城市ID列表.
        List<City> cityList;
        try {
            cityList= cityDataService.listCity();
        } catch (Exception e) {
            log.error("【定时同步天气数据】获取城市ID列表失败", e);
            throw new JobExecutionException(e);
        }

        // 2. 遍历城市ID获取天气数据.
        assert cityList != null;
        for (City city : cityList) {
            String cityId = city.getId();
            log.info("【定时同步天气数据】正在同步城市ID为{}的数据.", cityId);
            weatherDataService.syncWeatherDataByCityId(cityId);
        }

        log.info("【定时同步天气数据】已全部同步完成！");
    }
}
