package com.example.demo;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Rest1")
public class RestResource {
	
	@HystrixCommand(fallbackMethod="helloFallback",commandKey="hello",groupKey="hello")
	@RequestMapping("/hello")
	public String hello(){
		if(RandomUtils.nextBoolean()){
			throw new RuntimeException("Hello Service Failed");
			
		}
		return "Hello World";
	}
	
	public String helloFallback(){
		return "hello fall called";
	}
	
	

}
