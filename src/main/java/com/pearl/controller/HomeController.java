package com.pearl.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	@HystrixCommand(fallbackMethod="goHomeFallBack")
	public String goHome() {

		return "Welcome to Employee Service";
	}
	
	
	public String goHomeFallBack() {
		return "Error in connecting the server";
	}

}
