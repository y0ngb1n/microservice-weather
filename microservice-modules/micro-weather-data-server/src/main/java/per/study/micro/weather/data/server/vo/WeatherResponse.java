package per.study.micro.weather.data.server.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 天气信息的响应实体.
 *
 * @author yangbin
 **/
@Data
public class WeatherResponse implements Serializable {
    /** 天气数据. **/
    private Weather data;
    /** 异常码. **/
    private Integer status;
    /** 异常信息. **/
    private String desc;
}
