package com.asset.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/nameAndVersion")
	public String getAppNameAndVersion() {
		return "Application Name is: Test Cucumber, Version is: 1.0";
	}
}
