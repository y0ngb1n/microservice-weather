package per.study.micro.weather.report.server.service;

import per.study.micro.weather.report.server.vo.Weather;

/**
 * 天气预报.
 *
 * @author yangbin
 **/
public interface WeatherReportService {

    /**
     * 通过城市ID查询天气信息.
     *
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
