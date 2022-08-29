package com.wufang;

import com.alibaba.druid.pool.DruidDataSource;
import com.wufang.domain.serverProperties;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@EnableConfigurationProperties(serverProperties.class) //开启映射，生成一个Bean，serverProperties不能加@Component
public class SpringbootSsmpApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringbootSsmpApplication.class, args);
        serverProperties bean = run.getBean(serverProperties.class);
        System.out.println(bean);
    }

}
