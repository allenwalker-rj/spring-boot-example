package com.allen.properties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author allen
 * @date 2022/9/15 16:54
 */
@Configuration
@PropertySource("classpath:config/config.properties")
@ConfigurationProperties(prefix = "dev", ignoreUnknownFields = false)
@Component
@Data
public class MyConfig {
    private String username;
    private Integer age;
}
