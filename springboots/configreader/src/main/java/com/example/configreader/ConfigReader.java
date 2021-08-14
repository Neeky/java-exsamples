package com.example.configreader;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

/*
@Configuration
@ConfigurationProperties(prefix="person")
 */

@Data
public class ConfigReader {
    private String name;
    private int age;

    public ConfigReader(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public ConfigReader() {
        this("tom",16);
    }
}
