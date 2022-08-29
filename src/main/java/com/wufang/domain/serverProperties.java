package com.wufang.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@ConfigurationProperties(prefix = "spring.datasource")  //映射属性文件
public class serverProperties {
    private String type;
    private String driverclassname;
    private String url;
    private String username;
    private String password;

}
