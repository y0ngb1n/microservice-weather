package com.study.demo.microservice.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 昨日天气.
 *
 * @author yangbin
 **/
@Data
public class Yesterday implements Serializable {
    /** 日期. **/
    private String date;
    /** 最高温度. **/
    private String high;
    /** 风向. **/
    private String fx;
    /** 最低温度. **/
    private String low;
    /** 风力. **/
    private String fl;
    /** 天气类型. **/
    private String type;
}
