package br.com.eam.bestburger.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eam.bestburger.model.Guest;
import br.com.eam.bestburger.repository.GuestRepository;

@Controller
@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	private GuestRepository guestRepository;

	@GetMapping
	public String list(Model model) {
		model.addAttribute(new Guest());
		model.addAttribute("guests", guestRepository.findAll());
		return "guest/list";
	}
	
	@PostMapping
	public String save(Guest guest) {
		this.guestRepository.save(guest);
		return "redirect:/guests";
	}
	
	@GetMapping("/{id}")
	public String findOne(@PathVariable Long id) {
		Optional<Guest> guest = this.guestRepository.findById(id);
		
		System.out.println(guest.get());

		return "redirect:/guests";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		this.guestRepository.deleteById(id);
		return "redirect:/guests";
	}
	
	@GetMapping("/form")
	public String form(Guest guest, Model model) {
		model.addAttribute(guest);
		return "guest/form";
	}
}
