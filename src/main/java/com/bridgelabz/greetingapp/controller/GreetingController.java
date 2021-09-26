package com.bridgelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.GreetingService;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private GreetingService greetingService = new GreetingService();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam (value="name",defaultValue="world") String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
	
	@RequestMapping(value = {"/query"},method = RequestMethod.GET)
	public Greeting greeting(@RequestParam (value="name",defaultValue="") String name,@RequestParam (value="firstName",defaultValue="") String firstName,@RequestParam (value="lastName",defaultValue="") String lastName) {
		 
		return new Greeting(counter.incrementAndGet(),"Hello "+ name + firstName + " " + lastName);
		
	}
	
	@PostMapping(value="/addGreeting")
	public void addGretings(@RequestParam (value="name",defaultValue="") String name,@RequestParam (value="firstName",defaultValue="") String firstName,@RequestParam (value="lastName",defaultValue="") String lastName) {
		greetingService.addGreeting( new Greeting(counter.incrementAndGet(),"Hello "+ name + firstName + " " + lastName));
	}
	
	@RequestMapping(value = {"/get/{id}"},method = RequestMethod.GET)
	public Greeting greeting(@PathVariable long id) {	 
		return greetingService.findGreeting(id);
	}
	
}
