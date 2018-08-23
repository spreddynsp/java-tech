package com.vehicle.service.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class WelcomeController {

	@RequestMapping("/welcome.do")
    public String welcome(Locale locale, Model model) {   
    	System.out.println("entered into Welcome");
    		Date date = new Date();
    		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
    		String formattedDate = dateFormat.format(date);
    		model.addAttribute("serverTime", formattedDate);

        return "welcome";
    }
}
