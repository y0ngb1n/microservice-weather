package com.study.demo.microservice.weather.service;

import com.study.demo.microservice.weather.vo.City;

import java.util.List;

/**
 * City Data Service.
 *
 * @author yangbin
 **/
public interface CityDataService {

    /**
     * 获取城市列表.
     *
     * @return 城市列表.
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
