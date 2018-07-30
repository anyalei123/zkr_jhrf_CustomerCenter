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
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        String language_mark = request.getParameter("language_mark");
        Object session_mark =  request.getSession().getAttribute
                (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        String session_language_mark = "";
        if(StringUtils.isNotBlank(language_mark) && "en".equals(language_mark)){
            request.getSession().setAttribute
                    (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
        }
        if(StringUtils.isNotBlank(language_mark) && "zh".equals(language_mark)){
            request.getSession().setAttribute
                    (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        }
        if(StringUtils.isBlank(language_mark) && StringUtils.isBlank(language_mark) && session_mark != null){
            //String[] lan = session_mark.toString().split("_");
            //Locale locale = new Locale(lan[0], lan[1]);
            if("en_US".equals(session_mark.toString())){
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
            }
            if("zh_CN".equals(session_mark)){
                request.getSession().setAttribute
                        (SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
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
