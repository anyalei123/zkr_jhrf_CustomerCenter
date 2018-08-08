package com.bootdo.system.interceptor;

import com.bootdo.common.utils.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocaleInterceptor implements HandlerInterceptor{



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String locale = request.getLocale().toString();
        String language_mark = request.getParameter("language_mark");
        Object language = request.getSession().getAttribute
                (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);

        //mark not empty
        if(StringUtils.isNotBlank(language_mark)){
            if("zh_CN".equals(language_mark)){
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.CHINA);
            }
            if("en_US".equals(language_mark)){
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
            }
        }else{//mark empty
            if(language != null && "zh_CN".equals(language.toString())){//session not empty
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.CHINA);
            }
            if(language != null && "en_US".equals(language.toString())){//session not empty
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
            }
            if(language == null && locale.contains("zh")){//session not empty
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.CHINA);
            }
            if(language == null && "en".equals(locale)){//session not empty
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
