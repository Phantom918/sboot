package com.phantom.sboot.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: tan.lei
 * @Description: 属性文件映射
 * @Date: Create in 17:02 2017/11/16
 * @Modifiy:
 */
@Data
public class MyProperties {

    @Value("${com.neo.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;

}
