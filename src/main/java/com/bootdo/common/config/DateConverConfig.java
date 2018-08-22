package com.bootdo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * @author gaoyuzhe
 * @date 2017/12/14.
 */
@Configuration
public class DateConverConfig {
    @Bean
    public Converter<String, Date> stringDateConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                //判断前台传递的source是否为null或"",如果不为null并且不为""则进行日期转换
                if(source !=null && !source.equals("")){
                    try {
                        //如果字符串格式为"yyyy-MM-dd HH:mm:ss"，使用new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")转换
                        date = sdf.parse((String) source);
                    } catch (Exception e) {
                        //如果字符串格式不为"yyyy-MM-dd HH:mm:ss"，使用new SimpleDateFormat("yyyy-MM-dd")转换
                        SimpleDateFormat sdfday = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date = sdfday.parse((String) source);
                        } catch (ParseException e1) {
                            //如果字符串格式为其他格式，抛异常
                            e1.printStackTrace();
                        }
                    }
                }
                return date;
            }
        };
    }

}
