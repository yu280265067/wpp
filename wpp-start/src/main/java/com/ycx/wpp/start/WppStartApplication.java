package com.ycx.wpp.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

//@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
@ImportResource(locations = "classpath:applicationContext.xml")
@ComponentScan(basePackages = "com.ycx")
public class WppStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(WppStartApplication.class, args);
	}

}
