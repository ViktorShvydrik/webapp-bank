package com.belhard.webappbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/operator")
public class OperatorControllers {

	
	public String index (){
		
		return "operatorIndex.page";
		
	}
}
