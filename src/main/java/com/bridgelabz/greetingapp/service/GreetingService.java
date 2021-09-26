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
		return greetingList.stream().filter(n->n.getId()==id).findFirst().get();
	}
	
	public String allMessage() {
		String all = "";
		for ( Greeting x : greetingList) {
			all += x.toString();
		}
		return all;
	}
	
	public void updateMessage(long id, String message) {
		for( Greeting x : greetingList) {
			if (x.getId()==id) x.setMessage(message);
		}
	}
	
	public void deleteMessage(long id) {
		greetingList.removeIf(n->n.getId()==id);
	}
}
