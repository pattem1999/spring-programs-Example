package com.springboot.objectvalidation.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {

	@NotNull(message = "The message should not be null")
	@NotEmpty(message = "The message should not be empty")
	private String msg;
	@NotNull(message = "The from should not be null")
	@NotEmpty(message = "The from should not be empty")
	private String from;
	@NotNull(message = "The To should not be null")
	@NotEmpty(message = "The To should not be empty")
	private String to;
}
