package per.study.micro.weather.data.server.service;


import per.study.micro.weather.data.server.vo.WeatherResponse;

/**
 * Weather Data Service.
 *
 * @author yangbin
 **/
public interface WeatherDataService {
    /**
     * 通过城市ID获取天气数据.
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 通过城市名字获取天气数据.
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
