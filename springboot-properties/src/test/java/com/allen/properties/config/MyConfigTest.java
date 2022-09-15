package com.allen.properties.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MyConfigTest {

    @Autowired
    private MyConfig config;

    @Test
    void getUsername() {
        log.info("username : {}", config.getUsername());
    }

    @Test
    void getAge() {
        log.info("age : {}", config.getAge());
    }
}