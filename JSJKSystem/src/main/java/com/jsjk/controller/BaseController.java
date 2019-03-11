package com.jsjk.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}
	
}
