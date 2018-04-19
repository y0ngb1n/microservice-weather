package per.study.micro.weather.city.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.study.micro.weather.city.server.service.CityDataService;
import per.study.micro.weather.city.server.vo.City;

import java.util.List;

/**
 * 城市数据.
 *
 * @author yangbin
 **/
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
