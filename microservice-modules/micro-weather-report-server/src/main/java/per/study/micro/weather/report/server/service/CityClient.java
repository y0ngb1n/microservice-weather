package per.study.micro.weather.report.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import per.study.micro.weather.report.server.vo.City;

import java.util.List;

/**
 * @author yangbin
 **/
@FeignClient("micro-weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity();
}
