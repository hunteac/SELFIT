package com.ssafy.selfit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.selfit.model.dao")
public class SelfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfitApplication.class, args);
	}

}
