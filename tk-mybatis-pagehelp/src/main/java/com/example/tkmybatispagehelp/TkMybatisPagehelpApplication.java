package com.example.tkmybatispagehelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wangz
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.tkmybatispagehelp.mapper"})
public class TkMybatisPagehelpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkMybatisPagehelpApplication.class, args);
    }

}
