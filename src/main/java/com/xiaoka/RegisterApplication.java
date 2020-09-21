package com.xiaoka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = { "com.xiaoka.dao" })
public class RegisterApplication {
	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(RegisterApplication.class, args);
	}
}
