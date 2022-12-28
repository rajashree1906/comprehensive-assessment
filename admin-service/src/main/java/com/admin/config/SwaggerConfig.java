package com.admin.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/admin/**"))

				.build().apiInfo(getInfo());
		
	}

	private ApiInfo getInfo() {
		
		return new ApiInfo("Admin Service API", "admin","admin", "admin", new Contact("Rajashree", "http://localhost:8082/v2/api-docs", "ff"), "admin", "admin",new ArrayList<>());
	}

}
