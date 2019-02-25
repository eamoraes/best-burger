package br.com.eam.bestburger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.eam.bestburger.model.Guest;
import br.com.eam.bestburger.service.GuestService;

@Configuration
public class DataLoader implements CommandLineRunner {

	@Autowired
	private GuestService guestService;

	@Override
	public void run(String... args) throws Exception {
		addGuests();
	}

	private void addGuests() {
		
		for (int i = 0; i < 100; i++) {
			this.guestService.save(new Guest("Nome " + i, i));
		}
		
	}
	

}
