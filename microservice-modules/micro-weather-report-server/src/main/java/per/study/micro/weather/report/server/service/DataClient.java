package per.study.micro.weather.report.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import per.study.micro.weather.report.server.vo.City;
import per.study.micro.weather.report.server.vo.WeatherResponse;

import java.util.List;

/**
 * @author yangbin
 **/
@FeignClient("micro-weather-gateway-zuul")
public interface DataClient {

    /** 获取城市列表. */
    @GetMapping("/city/cities")
    List<City> listCity();

    /** 通过城市ID查询天气. */
    @GetMapping("/data/weather/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

    /** 通过城市名字查询天气. */
    @GetMapping("/data/weather/{cityName}")
    WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName);
}
