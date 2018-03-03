package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceUser4Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceUser4Application.class, args);
	}
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
