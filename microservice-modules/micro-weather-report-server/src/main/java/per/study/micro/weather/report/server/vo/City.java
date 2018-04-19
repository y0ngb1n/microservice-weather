package per.study.micro.weather.report.server.vo;

import lombok.Data;

/**
 * 城市信息.
 *
 * @author yangbin
 **/
@Data
public class City {
    /** 城市ID. **/
    private String id;
    /** 城市名字. **/
    private String name;
    /** 城市代码. **/
    private String code;
    /** 所属省份. **/
    private String province;
}
