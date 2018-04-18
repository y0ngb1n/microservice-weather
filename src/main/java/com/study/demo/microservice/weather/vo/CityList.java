package com.study.demo.microservice.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 城市信息集合.
 *
 * @author yangbin
 **/
@Data
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "d")
    private List<City> list;
}
