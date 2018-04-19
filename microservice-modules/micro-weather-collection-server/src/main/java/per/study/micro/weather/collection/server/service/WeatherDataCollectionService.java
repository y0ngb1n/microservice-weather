package per.study.micro.weather.collection.server.service;

/**
 * Weather Data Collection Service.
 *
 * @author yangbin
 **/
public interface WeatherDataCollectionService {

    /**
     * 通过城市ID同步天气数据.
     *
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
