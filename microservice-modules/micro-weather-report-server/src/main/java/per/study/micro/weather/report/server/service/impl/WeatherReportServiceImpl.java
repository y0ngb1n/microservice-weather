package per.study.micro.weather.report.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.study.micro.weather.report.server.service.DataClient;
import per.study.micro.weather.report.server.service.WeatherReportService;
import per.study.micro.weather.report.server.vo.Weather;
import per.study.micro.weather.report.server.vo.WeatherResponse;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weather = dataClient.getDataByCityId(cityId);
        return weather.getData();
    }
}
