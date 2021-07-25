package com.reactpro;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;
import static java.util.function.Predicate.isEqual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return regex("/api/hello.*")
				.or(regex("/api/users/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API Documentation")
				.description("Rest API reference for developers")
//				.termsOfServiceUrl("http://javainuse.com")
//				.contact(new Contact("", "", "sachin@gmail.com"))
//				.license("JavaInUse License")
//				.licenseUrl("javainuse@gmail.com").version("1.0")
				.build();
	}
	
}
