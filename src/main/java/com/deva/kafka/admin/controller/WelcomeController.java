package com.deva.kafka.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}
}
