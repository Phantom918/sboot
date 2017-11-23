package com.phantom.sboot.config;

import com.phantom.sboot.web.interceptor.MyInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: tan.lei
 * @Description: 配置自定义拦截器
 * @Date: Create in 11:20 2017/11/20
 * @Modifiy:
 */
@SpringBootConfiguration
public class WebAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/error");
    }
}
