package com.capstone.realmen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@EnableFeignClients
@ImportAutoConfiguration({ FeignAutoConfiguration.class })
@SpringBootApplication
public class RealmenApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealmenApplication.class, args);
	}

}
