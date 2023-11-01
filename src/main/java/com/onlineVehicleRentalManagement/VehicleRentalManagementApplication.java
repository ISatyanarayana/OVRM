package com.onlineVehicleRentalManagement;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class VehicleRentalManagementApplication {

	final static Logger logger = org.slf4j.LoggerFactory.getLogger("VehicleRentalManagementApplication.class");
	public static void main(String[] args) {
		SpringApplication.run(VehicleRentalManagementApplication.class, args);
		logger.info("OVRM application is running....");
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.onlineVehicleRentalManagement")).build();
	}
	//http://localhost:8081/swagger-ui.html#/

}
