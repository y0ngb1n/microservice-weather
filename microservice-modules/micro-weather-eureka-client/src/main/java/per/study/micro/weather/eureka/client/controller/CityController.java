package per.study.micro.weather.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.study.micro.weather.eureka.client.service.CityClient;

/**
 * @author yangbin
 **/
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public String listCity() {
        return cityClient.listCity();
    }
}
