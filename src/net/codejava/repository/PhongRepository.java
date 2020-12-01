package net.codejava.repository;

import org.springframework.data.repository.CrudRepository;

import net.codejava.model.Phong;

public interface PhongRepository extends CrudRepository<Phong, Long> {
	
}
