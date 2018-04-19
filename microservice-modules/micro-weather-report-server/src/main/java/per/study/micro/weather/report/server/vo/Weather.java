package per.study.micro.weather.report.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息.
 *
 * @author yangbin
 * @link http://wthrcdn.etouch.cn/weather_mini?city=佛山
 **/
@Data
public class Weather implements Serializable {
    /** 昨日天气. **/
    private Yesterday yesterday;
    /** 城市. **/
    private String city;
    /** 空气质量. **/
    private String aqi;
    /** 未来天气. **/
    private List<Forecast> forecast;
    /** 感冒提示. **/
    private String ganmao;
    /** 温度. **/
    private String wendu;
}
