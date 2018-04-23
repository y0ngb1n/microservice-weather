package per.study.micro.weather.report.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import per.study.micro.weather.report.server.service.DataClient;
import per.study.micro.weather.report.server.vo.City;
import per.study.micro.weather.report.server.vo.WeatherResponse;

import java.util.Collections;
import java.util.List;

/**
 * 服务熔断时的默认数据.
 *
 * @author yangbin
 **/
@Slf4j
@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<City> listCity() {
        log.warn("【服务熔断】城市数据API服务不可用.");
        City city = City.builder()
                .id("0").name("未知").code("unknown").province("未知")
                .build();
        return Collections.singletonList(city);
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return unavailableData();
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return unavailableData();
    }

    private WeatherResponse unavailableData() {
        log.warn("【服务熔断】天气数据API服务不可用.");
        return WeatherResponse.builder()
                .status(503).desc("服务不可用")
                .build();
    }
}
