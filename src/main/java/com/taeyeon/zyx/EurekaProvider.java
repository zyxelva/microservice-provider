package com.taeyeon.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableEurekaClient
@ImportResource("classpath:/spring/applicationContext.xml")
public class EurekaProvider {
	public static void main(String[] args) {
		System.out.println("++++++++++++++++++++++EurekaProvider Start+++++++++++++++++++++++++");
		SpringApplication.run(EurekaProvider.class, args);
		System.out.println("======================EurekaProvider Start is Done=========================");
	}
}
