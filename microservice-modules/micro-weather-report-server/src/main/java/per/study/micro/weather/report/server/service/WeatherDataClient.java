package per.study.micro.weather.report.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import per.study.micro.weather.report.server.vo.WeatherResponse;

/**
 * @author yangbin
 **/
@FeignClient("micro-weather-data-server")
public interface WeatherDataClient {

    @GetMapping("/weather/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
