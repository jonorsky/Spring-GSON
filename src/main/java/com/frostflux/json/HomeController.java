package com.frostflux.json;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

@Controller
public class HomeController {

	String beautify(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Object obj = mapper.readValue(json, Object.class);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	}

	@RequestMapping("/")
	public String home(Model model) {
		JsonObject person = new JsonObject();
		person.addProperty("firstName", "Ed");
		person.addProperty("lastName", "Manzano");

		try {
			model.addAttribute("parameter", beautify(person.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "home";
	}

}
