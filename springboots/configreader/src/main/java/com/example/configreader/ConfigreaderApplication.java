package com.example.configreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigreaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigreaderApplication.class, args);


        Person p = new Person();
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }

}
