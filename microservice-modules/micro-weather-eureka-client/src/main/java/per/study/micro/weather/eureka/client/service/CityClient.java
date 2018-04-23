package per.study.micro.weather.eureka.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yangbin
 **/
@FeignClient("micro-weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
