package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.baizhi.dao")
@SpringBootApplication
public class Cmfz extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Cmfz.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Cmfz.class);
    }
}
