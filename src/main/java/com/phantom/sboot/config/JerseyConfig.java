package com.phantom.sboot.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * @Description: jersey配置
 * @Author: tan.lei
 * @Date: 2017/11/22 13:58
 */
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.phantom.sboot.jersey");//配置restful package.
    }
}
