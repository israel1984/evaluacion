package com.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan({"com.evaluacion.service"})
//@EntityScan("com.evaluacion.model")
//@EnableJpaRepositories("com.evaluacion.repository")
public class EvaluacionApplication /*extends SpringBootServletInitializer*/{

	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(EvaluacionApplication.class);
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
	}

}
