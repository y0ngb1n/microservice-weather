package com.study.demo.microservice.weather.controller;

import com.study.demo.microservice.weather.service.WeatherDataService;
import com.study.demo.microservice.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Weather Controller.
 *
 * @author yangbin
 **/
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired private WeatherDataService weatherDataService;

    /**
     * 通过城市ID获取天气数据.
     *
     * @param cityId
     * @return
     */
    @GetMapping("/{cityId:\\d+}")
    public WeatherResponse getWeatherByCityId(@PathVariable String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    /**
     * 通过城市名字获取天气数据.
     *
     * @param cityName
     * @return
     */
    @GetMapping("/{cityName:\\D+}")
    public WeatherResponse getWeatherByCityName(@PathVariable String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
