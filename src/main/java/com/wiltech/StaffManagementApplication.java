package com.wiltech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan({"com.wiltech"})
public class StaffManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementApplication.class, args);
	}

}
