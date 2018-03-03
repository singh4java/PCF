package com.example.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@SpringBootApplication

@RestController
public class SpringSleuthApplication {
	public static Logger LOG = Logger.getLogger(SpringSleuthApplication.class.getName());

	@Autowired
	RestTemplate restTemplate;
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	

	public static void main(String[] args) {
		SpringApplication.run(SpringSleuthApplication.class, args);
	}
	
	@RequestMapping(value="/ZipkinCall")
	public User helloZipkin(){
		LOG.log(Level.INFO, "you called helloZipkin");
		return this.restTemplate.getForObject("http://localhost:8080/API", User.class);
		//return "Hello World....helloZipkin";
	}
	
	@RequestMapping(value="/ZipkinAPIGATEWAY")
	public User helloZipkinApigateway(){
		LOG.log(Level.INFO, "you called helloZipkinApigateway");
		return this.restTemplate.getForObject("http://localhost:8888/user4/GET", User.class);
		//return "Hello World....helloZipkin";
	}
	
	@RequestMapping(value="/")
	public String hello(){
		LOG.log(Level.INFO, "you called hello");
		return "Hello World....hello";
	}
	
	@RequestMapping(value="/home")
	public String home(){
		LOG.log(Level.INFO, "you called home");
		return "Hello World....home";
	}
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
