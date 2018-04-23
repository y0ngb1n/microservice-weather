package per.study.micro.weather.report.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import per.study.micro.weather.report.server.service.DataClient;
import per.study.micro.weather.report.server.service.WeatherReportService;

/**
 * 天气预报.
 *
 * @author yangbin
 **/
@Controller
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private DataClient dataClient;

    @GetMapping
    public ModelAndView index(Model model) throws Exception {
        return getWeatherByCityId("101282001", model);
    }

    /**
     * 通过城市ID获取天气数据.
     *
     * @param cityId
     * @return
     */
    @GetMapping("/{cityId:\\d+}")
    public ModelAndView getWeatherByCityId(@PathVariable String cityId, Model model) throws Exception {
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", dataClient.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "weatherReport", model);
    }
}
