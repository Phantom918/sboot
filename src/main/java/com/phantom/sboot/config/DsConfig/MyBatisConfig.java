package com.phantom.sboot.config.DsConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: tan.lei
 * @Date: 2017/11/24 10:25
 */
@Configuration
@MapperScan(basePackages = "com.phantom.sboot.dao")
public class MyBatisConfig {

    @Value("${mybatis.type-aliases-package}")
    private String typeAliases;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocation;

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDS1") DataSource dynamicDS1) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDS1);// 指定数据源
        //如果持久层未使用xml文件（只用注解就可以搞定）则不加
        factoryBean.setTypeAliasesPackage(typeAliases);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return factoryBean.getObject();
    }

}
