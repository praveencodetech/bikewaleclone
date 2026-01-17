package com.bikewale.clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BikeWaleCloneApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BikeWaleCloneApplication.class);
		java.util.Properties props = new java.util.Properties();
		props.setProperty("server.port", "8081");
		app.setDefaultProperties(props);
		app.run(args);
	}

}
