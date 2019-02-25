package br.com.eam.bestburger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eam.bestburger.model.EntityBase;

public class CrudService<T extends EntityBase<ID>, ID> {
	
	@Autowired
	private JpaRepository<T, ID> repository;
	
	public T save(T entity) {
		return repository.save(entity);
	}
	
	public T update(T entity, ID id) throws Exception {
		if (!id.equals(entity.getId())) {
			throw new Exception("commons.message.updateFailure");
		}
			
		return repository.save(entity);
	}

	public Optional<T> delete(ID id) {
		Optional<T> entity = this.findById(id);
		if (!entity.isPresent()) {
			return Optional.empty();
		}
		repository.delete(entity.get());
		return entity;
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}

	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}
	
	public Page<T> findAll(Example<T> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}
	
	public List<T> findAll(Example<T> example) {
		return repository.findAll(example);
	}

}
