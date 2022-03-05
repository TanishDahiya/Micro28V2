package com.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.entities.LimitValueThroughProperties;
import com.microservices.limitsservice.entities.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitValueThroughProperties lvtp;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(1,1000);

	}
	
	//New set limit technique through properties file
	@GetMapping("/limitsnew")
	public Limits retrieveLimitsnewTechnique() {
		return new Limits(lvtp.getMinimum(),lvtp.getMaximum());

	}

}
