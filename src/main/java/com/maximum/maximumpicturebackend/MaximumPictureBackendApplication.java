package com.maximum.maximumpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.maximum.maximumpicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class MaximumPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaximumPictureBackendApplication.class, args);
    }

}
