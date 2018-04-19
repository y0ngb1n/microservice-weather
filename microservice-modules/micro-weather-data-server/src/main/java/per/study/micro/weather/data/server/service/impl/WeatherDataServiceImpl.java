package per.study.micro.weather.data.server.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import per.study.micro.weather.data.server.service.WeatherDataService;
import per.study.micro.weather.data.server.vo.WeatherResponse;

import java.io.IOException;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static String WEATHER_PROVIDER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = String.format("%s%s%s", WEATHER_PROVIDER_URL, "citykey=", cityId);
        return this.getWeatherData(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = String.format("%s%s%s", WEATHER_PROVIDER_URL, "city=", cityName);
        return this.getWeatherData(url);
    }

    /**
     * 获取天气数据.
     *
     * @param url 目标地址
     * @return WeatherResponse
     */
    private WeatherResponse getWeatherData(String url) {
        String cacheKey = buildWeatherDataCacheKeyByUrl(url);
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String json = null;
        WeatherResponse weatherResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();

        // 1. 从缓存中获取
        if (stringRedisTemplate.hasKey(cacheKey)) {
            log.debug("【获取天气数据】从缓存中获取：{}", url);
            json = ops.get(cacheKey);
        }
        // 2. 缓存中没有数据
        else {
            String errorMessage = String.format("【获取天气数据】缓存中没有数据：%s", url);
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        // json to entity.
        try {
            weatherResponse = objectMapper.readValue(json, WeatherResponse.class);
        } catch (IOException e) {
            log.error("【获取天气数据】无法获取天气数据：{}", e);
        }
        return weatherResponse;
    }

    /**
     * 根据URL构建天气数据的缓存Key.
     *
     * @param url
     * @return 缓存Key.
     */
    private String buildWeatherDataCacheKeyByUrl(String url) {
        return String.format("weather:data:%s",
                url.replace(WEATHER_PROVIDER_URL, "").replace('=', ':'));
    }
}
