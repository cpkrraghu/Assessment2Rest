package com.raghu.flightrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.raghu.flightrest","com.raghu.flightrepo"})
public class RestApp {
	public static void main(String[] args) {
		SpringApplication.run(RestApp.class, args);
	}
}
