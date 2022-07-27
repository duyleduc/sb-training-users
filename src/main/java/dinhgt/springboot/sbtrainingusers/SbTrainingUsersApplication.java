package dinhgt.springboot.sbtrainingusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableEurekaClient
@AutoConfiguration
public class SbTrainingUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbTrainingUsersApplication.class, args);
	}

}
