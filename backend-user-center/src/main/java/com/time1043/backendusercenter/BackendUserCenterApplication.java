package com.time1043.backendusercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.time1043.backendusercenter.mapper")
public class BackendUserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendUserCenterApplication.class, args);
    }

}
