package com.phantom.sboot.config.DsConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: tan.lei
 * @Date: 2017/11/24 10:05
 */
@Configuration
public class DataSourceConfig {

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * @return
     * @throws Exception
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Primary
    @Bean("ds1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean("ds2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dynamicDS1")
    public DataSource dataSource() {
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("ds1", dataSource1());
        dsMap.put("ds2", dataSource2());
        // 设置数据源
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}
