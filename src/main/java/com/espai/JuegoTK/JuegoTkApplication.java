package com.espai.JuegoTK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JuegoTkApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuegoTkApplication.class, args);
	}

}
