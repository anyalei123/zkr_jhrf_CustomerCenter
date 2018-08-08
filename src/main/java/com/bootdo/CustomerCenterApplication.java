package com.bootdo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.bootdo.*.dao")
//@MapperScan({"com.bootdo.*.dao","com.zkr.*.dao"})
@SpringBootApplication
@EnableCaching
public class CustomerCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerCenterApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    九恒仁福P03客户中心---启动成功      ヾ(◍°∇°◍)ﾉ");
        
    }
}
