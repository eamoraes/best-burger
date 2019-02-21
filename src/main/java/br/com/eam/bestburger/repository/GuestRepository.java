package br.com.eam.bestburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eam.bestburger.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
