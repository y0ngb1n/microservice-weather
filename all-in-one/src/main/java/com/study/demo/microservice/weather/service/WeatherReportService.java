package com.study.demo.microservice.weather.service;

import com.study.demo.microservice.weather.vo.Weather;

/**
 * 天气预报.
 *
 * @author yangbin
 **/
public interface WeatherReportService {

    /**
     * 通过城市ID查询天气信息.
     *
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
