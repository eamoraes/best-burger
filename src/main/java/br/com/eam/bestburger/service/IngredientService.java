package br.com.eam.bestburger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eam.bestburger.model.Ingredient;
import br.com.eam.bestburger.repository.IngredientRepository;

@Service
public class IngredientService extends CrudService<Ingredient, Long> {
	@Autowired
	IngredientRepository ingredientRepository;
	
	public void saveAll(List<Ingredient> ingredients) {
		for (Ingredient ingredient : ingredients) {
			this.save(ingredient);
		}
	}

	public Ingredient findByName(String string) {
		return ingredientRepository.findByName(string);
	}

}
