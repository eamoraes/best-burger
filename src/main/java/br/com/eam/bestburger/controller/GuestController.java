package br.com.eam.bestburger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "GuestList";
	}
	
	@PostMapping
	public String save(Guest guest) {
		this.guestRepository.save(guest);
		return "redirect:/guests";
	}
}
