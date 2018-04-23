package per.study.micro.weather.collection.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import per.study.micro.weather.collection.server.vo.City;

import java.util.List;

/**
 * @author yangbin
 **/
@FeignClient("micro-weather-gateway-zuul")
public interface DataClient {

    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;
}
