package per.study.micro.weather.collection.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import per.study.micro.weather.collection.server.service.WeatherDataCollectionService;

import java.util.concurrent.TimeUnit;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final static String WEATHER_PROVIDER_URL = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final Long CACHE_TIMEOUT_SECONDS = 1800L;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        String url = String.format("%s%s%s", WEATHER_PROVIDER_URL, "citykey=", cityId);
        saveWeatherData(url);
    }

    /**
     * 保存天气数据.
     *
     * @param url
     */
    private void saveWeatherData(String url) {
        String cacheKey = buildWeatherDataCacheKeyByUrl(url);
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String json;

        log.debug("【保存天气数据】正在请求数据源：{}", url);
        // 获取天气数据
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        if (entity.getStatusCode() == HttpStatus.OK) {
            json = entity.getBody();
            // 将数据写入缓存
            ops.set(cacheKey, json, CACHE_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        }
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
