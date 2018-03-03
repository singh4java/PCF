package com.example.demo;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Rest2")
public class RestResourceHystrix_1 {
	
	@HystrixCommand(fallbackMethod="RestResourceHystrix_1helloFallback",commandKey="hello_Hystrix",groupKey="hello_Hystrix")
	@RequestMapping("/hello")
	public String hello(){
		if(RandomUtils.nextBoolean()){
			throw new RuntimeException("RestResourceHystrix_1 Hello Service Failed");
			
		}
		return "RestResourceHystrix_1 Hello World";
	}
	
	public String RestResourceHystrix_1helloFallback(){
		return "RestResourceHystrix_1 hello fall called";
	}
	
	

}
