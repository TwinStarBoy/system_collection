package com.blackjade.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blackjade.crm.dao") // 扫描dao的接口类
public class CrmCApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmCApplication.class, args);
	}
	
}
