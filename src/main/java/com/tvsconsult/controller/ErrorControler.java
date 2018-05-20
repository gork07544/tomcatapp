package com.tvsconsult.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorControler {

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error(@RequestParam(value = "code", required = false) String code)
{
		ModelAndView model = new ModelAndView();
		
		if (code != null) {
			model.addObject("msg", code);
		}
		
		model.setViewName("error");
		return model;
	}
	
}
