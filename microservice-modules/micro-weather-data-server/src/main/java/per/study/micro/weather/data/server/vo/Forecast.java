package per.study.micro.weather.data.server.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 未来天气.
 *
 * @author yangbin
 **/
@Data
public class Forecast implements Serializable {
    /** 日期. **/
    private String date;
    /** 最高温度. **/
    private String high;
    /** 风向. **/
    private String fengxiang;
    /** 最低温度. **/
    private String low;
    /** 风力. **/
    private String fengli;
    /** 天气类型. **/
    private String type;
}
