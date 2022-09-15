package com.allen.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author allen
 * @date 2022/9/15 16:44
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootPropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPropertiesApplication.class, args);
    }

}
