package br.com.eam.bestburger.controller;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eam.bestburger.model.Guest;
import br.com.eam.bestburger.service.GuestService;

@Controller
@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	private GuestService guestService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute(new Guest());
		if (!model.containsAttribute("guests")) {
			model.addAttribute("guests", guestService.findAll());
		}
		return "guest/list";
	}
	
	@GetMapping("/form")
	public String form(Guest guest, Model model) {
		model.addAttribute(guest);
		return "guest/form";
	}
	
	@PostMapping
	public String save(Guest guest) {
		this.guestService.save(guest);
		return "redirect:/guests";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		this.guestService.delete(id);
		return "redirect:/guests";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		return form(this.guestService.findById(id).get(), model);
	}

	@GetMapping("/{id}")
	public String findOne(@PathVariable Long id, Model model) {
		Optional<Guest> guest = this.guestService.findById(id);
		
		List<Guest> guests = Arrays.asList(guest.get());
		
		model.addAttribute("guests", guests);
		
		return list(model);
	}
	
	@PostMapping("/search")
	public String search(Guest guest,
			@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageRequest, 
			Model model) {
		
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase().
									withMatcher("name", contains().ignoreCase()).
									withMatcher("companionAmount", exact());

		Example<Guest> search = Example.of(guest, matcher);

		Page<Guest> guests = this.guestService.findAll(search, pageRequest);
		
		List<Guest> guests2 = guests.getContent();
		
		model.addAttribute("guests", guests2);
		
		return list(model);
	}
}
