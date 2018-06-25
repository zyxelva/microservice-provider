package com.taeyeon.zyx;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class EurekaProvider {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaProvider.class).web(true).run(args);
	}
}
