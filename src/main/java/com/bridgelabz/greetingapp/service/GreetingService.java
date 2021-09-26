package com.bridgelabz.greetingapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.greetingapp.model.Greeting;

public class GreetingService {
	
	public static List<Greeting> greetingList = new ArrayList<>();

	public void addGreeting(Greeting greeting) {
		greetingList.add(greeting);
	}
	
	public Greeting findGreeting(long id) {
		for ( Greeting x : greetingList) {
			if (x.getId()==id) return x;
		}
		return new Greeting(0, null);
	}
}
