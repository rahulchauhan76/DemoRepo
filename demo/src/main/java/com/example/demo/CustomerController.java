package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController

//@RequestMapping("/api")
public class CustomerController {
	
	private static List<Customer> list=new ArrayList<Customer>();
	
	static {
	list.add(new Customer(1,"Rahul"));
	list.add(new Customer(1,"Nishant"));
	
	}
	
	
	
	@RequestMapping(value="/api/customers/getAllcustomers",method=RequestMethod.GET)
	@ResponseBody
	public List<Customer> getAllCustomer()
	{
		return list;
	}
	
	@RequestMapping(value="/api/customers/student",method=RequestMethod.GET)
	@ResponseBody
	public List<Customer> getStudent()
	{
		return list;
	}
	
	
	

	
}
