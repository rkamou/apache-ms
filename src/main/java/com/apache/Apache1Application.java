package com.apache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.apache.service.impl.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class Apache1Application {

	public static void main(String[] args) {
		SpringApplication.run(Apache1Application.class, args);
	}

}
