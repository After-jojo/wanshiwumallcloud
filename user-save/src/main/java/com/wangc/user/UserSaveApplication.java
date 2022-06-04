package com.wangc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.wangc.user.dao")
public class UserSaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSaveApplication.class, args);
    }

}
