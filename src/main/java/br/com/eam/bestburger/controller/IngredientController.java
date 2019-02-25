package br.com.eam.bestburger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eam.bestburger.model.Ingredient;
import br.com.eam.bestburger.service.IngredientService;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute(new Ingredient());
		if (!model.containsAttribute("ingredients")) {
			model.addAttribute("ingredients", ingredientService.findAll());
		}
		return "ingredient/list";
	}

}
