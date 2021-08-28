package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Student student = context.getBean("student",Student.class);
        System.out.println(student);

        ApplicationContext c = new ClassPathXmlApplicationContext("application.xml");
        ApplicationContext s = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(c == s);
        System.out.println(c.hashCode());
        System.out.println(s.hashCode());

    }
}
