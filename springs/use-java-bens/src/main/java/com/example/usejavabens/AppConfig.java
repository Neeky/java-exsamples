package com.example.usejavabens;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 这个注定类似说这个类就是一个 bean 的配置文件
public class AppConfig {


    @Bean // 告诉 Spring 这是一个 bean ，到时候要把它放到 IOC 容器中去
    public Person person() {
        return new Person();
    }
}
