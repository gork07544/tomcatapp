package com.tvsconsult.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogIn {

	// Spring Security see this :
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "expired", required = false) String expired) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("msg", "Invalid username or password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		if (expired != null) {
			model.addObject("msg", "The session has been expired. You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
}
