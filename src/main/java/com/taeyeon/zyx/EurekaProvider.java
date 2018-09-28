package com.taeyeon.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@ImportResource("classpath:/spring/applicationContext.xml")
//@MapperScan("com.taeyeon.zyx.dao")
//public class EurekaProvider extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(EurekaProvider.class);
//	}

public class EurekaProvider {
	public static void main(String[] args) {
		System.out.print("+++++++++++++++++++++++"+new Date()+"++++++++++++++++++++++++");
//		new SpringApplicationBuilder(EurekaProvider.class).web(true).run(args);
		SpringApplication.run(EurekaProvider.class, args);
		System.out.print("======================"+new Date()+"=========================");
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setIgnoreUnresolvablePlaceholders(true);
		return c;
	}
////
////	@Bean
////	public FilterRegistrationBean resourceBaseUrlFilterRegistration() {
////		FilterRegistrationBean registration = new FilterRegistrationBean();
////		registration.setFilter(new ResourceBaseUrlFilter());
////		registration.addUrlPatterns("/*");
////		registration.setName("resourceBaseUrlFilter");
////		registration.setOrder(2);
////		return registration;
////	}
}
