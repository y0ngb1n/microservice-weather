package com.study.demo.microservice.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市信息.
 *
 * @author yangbin
 **/
@Data
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    /** 城市ID. **/
    @XmlAttribute(name = "d1")
    private String id;
    /** 城市名字. **/
    @XmlAttribute(name = "d2")
    private String name;
    /** 城市代码. **/
    @XmlAttribute(name = "d3")
    private String code;
    /** 所属省份. **/
    @XmlAttribute(name = "d4")
    private String province;
}
