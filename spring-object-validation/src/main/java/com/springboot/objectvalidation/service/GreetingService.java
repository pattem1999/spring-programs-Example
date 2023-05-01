package com.springboot.objectvalidation.service;

import java.util.stream.Collectors;

import javax.validation.Validator;

import org.springframework.stereotype.Service;

import com.springboot.objectvalidation.model.Greeting;
import com.springboot.objectvalidation.validation.ObjectValidators;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GreetingService {

	private final ObjectValidators objectValidators;
	public String saveGreeting(Greeting greeting) {
		// TODO Auto-generated method stub
		
		var violations=objectValidators.validate(greeting);
		if(!violations.isEmpty())
		{
			/*
			 * //return Violations .stream() .collect(Collectors.joining("  | "));
			 */
			
			return String.join(" \n ",violations);
		}
		final String greetingMsg = "Greeting message <<" + greeting.getMsg() + 
				">> from: " 
				+ greeting.getFrom().toUpperCase()
				+"to:"+greeting.getTo().toUpperCase();
		return greetingMsg;
	}

}
