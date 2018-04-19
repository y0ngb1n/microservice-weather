package per.study.micro.weather.report.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.study.micro.weather.report.server.service.WeatherReportService;
import per.study.micro.weather.report.server.vo.Forecast;
import per.study.micro.weather.report.server.vo.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getDataByCityId(String cityId) {

        // TODO 从天气数据API微服务获取数据

        Weather data = new Weather();
        data.setCity("茂名");
        data.setWendu("18");
        data.setAqi("88");
        data.setGanmao("注意保暖！");

        Forecast forecast = new Forecast();
        forecast.setDate("29日星期四");
        forecast.setType("阵雨");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温23℃");
        forecast.setLow("低温16℃");

        List<Forecast> forecasts = new ArrayList<>();
        forecasts.add(forecast);

        data.setForecast(forecasts);

        return data;
    }
}
