package com.frostflux.json;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		JsonObject person = new JsonObject();
		person.addProperty("firstName", "Ed");
		person.addProperty("lastName", "Manzano");

		model.addAttribute("parameter", person.toString());

		return "home";
	}

}
