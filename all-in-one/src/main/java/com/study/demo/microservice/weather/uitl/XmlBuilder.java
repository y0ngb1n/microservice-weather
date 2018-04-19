package com.study.demo.microservice.weather.uitl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XML Builder.
 *
 * @author yangbin
 **/
public class XmlBuilder {
    private XmlBuilder() {}

    /**
     * 将XML转为指定的POJO.
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // XML转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Reader reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        reader.close();
        return xmlObject;
    }
}
