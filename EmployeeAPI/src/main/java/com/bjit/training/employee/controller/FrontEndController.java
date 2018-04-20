package com.bjit.training.employee.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/showEdit")
	public String showEdit() {
		return "showEdit";
	}
	
}