package com.springboot.objectvalidation.controller;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.objectvalidation.model.Greeting;
import com.springboot.objectvalidation.service.GreetingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public class GreetingController {

	private final GreetingService greetingService;
	
	@PostMapping
	public ResponseEntity<String> postGreeting(@RequestBody 
			@Valid Greeting greeting,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return ResponseEntity.badRequest()
					.body(bindingResult.getAllErrors()
							.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining()));
		}
		
		
		final String greetingMsg=greetingService.saveGreeting(greeting);
		return ResponseEntity.accepted().body(greetingMsg);
	}
	
	
	
	//========== better approach================
	
	
}
