package com.example.demo;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Rest3")
public class RestResourceHystrix_2 {
	
	@HystrixCommand(fallbackMethod="RestResourceHystrix_2helloFallback",commandKey="hello_Hystrix2",groupKey="hello_Hystrix2")
	@RequestMapping("/hello")
	public String hello(){
		if(RandomUtils.nextBoolean()){
			throw new RuntimeException("RestResourceHystrix_2 Hello Service Failed");
			
		}
		return "RestResourceHystrix_2 Hello World";
	}
	
	public String RestResourceHystrix_2helloFallback(){
		return "RestResourceHystrix_2 hello fall called";
	}
	
	

}
