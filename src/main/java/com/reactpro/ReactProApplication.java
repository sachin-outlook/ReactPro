package com.reactpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@ComponentScan(excludeFilters={
//		@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value={HelloWorld.class})}
//)
@EnableJpaRepositories
@EnableTransactionManagement
public class ReactProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactProApplication.class, args);
	}

}
