package br.com.eam.bestburger.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.eam.bestburger.model.Guest;
import br.com.eam.bestburger.model.Ingredient;
import br.com.eam.bestburger.service.GuestService;
import br.com.eam.bestburger.service.IngredientService;

@Configuration
public class DataLoader implements CommandLineRunner {

	@Autowired
	private GuestService guestService;
	
	@Autowired
	private IngredientService ingredientService;

	@Override
	public void run(String... args) throws Exception {
		addGuests();
		addIngredients();
	}

	private void addGuests() {
		for (int i = 0; i < 50; i++) {
			this.guestService.save(new Guest("Nome " + i, i));
		}
	}
	
	private void addIngredients() {
		Ingredient alface = new Ingredient("Alface", new BigDecimal("0.40"));
		Ingredient bacon = new Ingredient("Bacon", new BigDecimal("2.00"));
		Ingredient hamburguer = new Ingredient("Hambúrguer de carne", new BigDecimal("3.00"));
		Ingredient ovo = new Ingredient("Ovo", new BigDecimal("0.80"));
		Ingredient queijo = new Ingredient("Queijo", new BigDecimal("1.50"));
		
		this.ingredientService.saveAll(Arrays.asList(alface, bacon, 
				hamburguer, ovo, queijo));
	}

}
