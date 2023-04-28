package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
//@EnableJpaRepositories("com.driver.repository")
//@EntityScan("com.driver")
public class Uber {

	public static void main(String[] args) {
		SpringApplication.run(Uber.class, args);
	}

}
