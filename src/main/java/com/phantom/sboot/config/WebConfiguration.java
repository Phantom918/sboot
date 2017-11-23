package com.phantom.sboot.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.phantom.sboot.web.interceptor.MyInterceptor;
import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tan.lei
 * @Description:
 * @Date: Create in 16:57 2017/11/16
 * @Modifiy:
 */
@Configuration
public class WebConfiguration {

    private Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    public class MyFilter implements Filter {

        @Override
        public void destroy() {
            // TODO Auto-generated method stub
            logger.info("进入MyFilter ==> destroy()");
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            logger.info("进入MyFilter ==> init()");
            HttpServletRequest request = (HttpServletRequest) srequest;
            System.out.println("this is MyFilter,url :" + request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
            // TODO Auto-generated method stub
            logger.info("进入MyFilter ==> init()");
        }
    }


    /*//监听器
    @Bean
    public ServletListenerRegistrationBean<MyInterceptor> myListener() {
        return new ServletListenerRegistrationBean<MyInterceptor>(new MyInterceptor());
    }*/

}
