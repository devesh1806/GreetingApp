package com.bridgelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam (value="name",defaultValue="world") String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
	
	@RequestMapping(value = {"/query"},method = RequestMethod.GET)
	public Greeting greeting(@RequestParam (value="name",defaultValue="") String name,@RequestParam (value="firstName",defaultValue="") String firstName,@RequestParam (value="lastName",defaultValue="") String lastName) {
		 
		return new Greeting(counter.incrementAndGet(),String.format(template, name)+ firstName + " " + lastName);
		
	}
	
}
