package com.study.demo.microservice.weather.service.impl;

import com.study.demo.microservice.weather.service.WeatherDataService;
import com.study.demo.microservice.weather.service.WeatherReportService;
import com.study.demo.microservice.weather.vo.Weather;
import com.study.demo.microservice.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);
        return weatherResponse.getData();
    }
}
