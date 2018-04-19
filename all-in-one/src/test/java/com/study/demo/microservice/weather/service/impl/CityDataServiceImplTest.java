package com.study.demo.microservice.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.demo.microservice.weather.vo.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yangbin
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDataServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(CityDataServiceImplTest.class);

    @Autowired
    private CityDataServiceImpl cityDataServiceImpl;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testListCityWhenSuccess() throws Exception {
        List<City> cities = cityDataServiceImpl.listCity();
        log.info(objectMapper.writeValueAsString(cities));
    }
}