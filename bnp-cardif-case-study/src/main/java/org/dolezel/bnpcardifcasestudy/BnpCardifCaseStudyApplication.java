package org.dolezel.bnpcardifcasestudy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient //the discovery will fail as no server is configured
@OpenAPIDefinition(info = @Info(title = "Insurance API"))
public class BnpCardifCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BnpCardifCaseStudyApplication.class, args);
	}

}
