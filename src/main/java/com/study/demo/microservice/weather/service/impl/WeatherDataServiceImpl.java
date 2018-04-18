package com.study.demo.microservice.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.demo.microservice.weather.service.WeatherDataService;
import com.study.demo.microservice.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static String WEATHER_PROVIDER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = String.format("%s%s%s", WEATHER_PROVIDER_URL, "citykey=", cityId);
        return this.getWeatherData(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = String.format("%s%s%s", WEATHER_PROVIDER_URL, "city=", cityName);
        return this.getWeatherData(url);
    }

    /**
     * 获取天气数据.
     *
     * @param url 目标地址
     * @return WeatherResponse
     */
    private WeatherResponse getWeatherData(String url) {
        log.debug("【获取天气数据】正在请求：{}", url);
        // 获取天气数据
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        WeatherResponse weatherResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        if (entity.getStatusCode() == HttpStatus.OK) {
            json = entity.getBody();
        }
        // json to entity.
        try {
            weatherResponse = objectMapper.readValue(json, WeatherResponse.class);
        } catch (IOException e) {
            log.error("【获取天气数据】无法获取天气数据：{}", e);
        }
        return weatherResponse;
    }
}
