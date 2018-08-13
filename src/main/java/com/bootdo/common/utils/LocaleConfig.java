package com.bootdo.common.utils;

import com.bootdo.system.interceptor.LocaleInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class LocaleConfig extends WebMvcConfigurerAdapter {
    HttpServletRequest request;
    public Locale locale;


    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // 默认语言
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        String language = lci.getParamName();
        // 参数名
        lci.setParamName("lang");
        return lci;
    }
//    @Bean
//    public LocaleInterceptor localeInterceptor(){
//        return new LocaleInterceptor();
//    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//        registry.addInterceptor(new LocaleInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/**/fonts/*").excludePathPatterns("/**/*.css")
//                .excludePathPatterns("/**/*.js").excludePathPatterns("/**/*.jpg")
//                .excludePathPatterns("/**/*.png").excludePathPatterns("/**/*.gif*")
//                .excludePathPatterns("/**/*.jpeg").excludePathPatterns("/login")
//                .excludePathPatterns("/common/dict/type")
//                .excludePathPatterns("/common/dict").excludePathPatterns("/oa/notify/message");
//
//    }

}
