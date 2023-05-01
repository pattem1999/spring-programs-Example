package com.springboot.objectvalidation.validation;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.springboot.objectvalidation.model.Greeting;

@Component
public class ObjectValidators {

	private final ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();
	
	private final Validator validator=validatorFactory.getValidator();
	
	
	public Set<String> validate(Greeting objectToValidator){
		Set<ConstraintViolation<Greeting>> violations= validator.validate(objectToValidator);
		if(!violations.isEmpty())
		{
			return violations
					.stream()
					.map(ConstraintViolation::getMessage)
					.collect(Collectors.toSet());
		}
		
		
		return Collections.emptySet();
	
	}
}
