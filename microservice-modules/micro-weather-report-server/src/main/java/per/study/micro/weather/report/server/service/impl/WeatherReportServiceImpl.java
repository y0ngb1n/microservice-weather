package per.study.micro.weather.report.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.study.micro.weather.report.server.service.WeatherDataClient;
import per.study.micro.weather.report.server.service.WeatherReportService;
import per.study.micro.weather.report.server.vo.Forecast;
import per.study.micro.weather.report.server.vo.Weather;
import per.study.micro.weather.report.server.vo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weather = weatherDataClient.getDataByCityId(cityId);
        return weather.getData();
    }
}
