package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableAutoConfiguration
@RestController
@EnableSwagger2

public class HelloController {

	@RequestMapping(value="/api/helloworld",method=RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "hello world"; 	
	}
	
	@RequestMapping(value = " ",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String greetings(@RequestBody String Name) {
		
			return "Hello "+ Name;
		
	}
	
	//public static void main(String[] args) {
	//	SpringApplication.run(HelloController.class, args);
	//}
}
