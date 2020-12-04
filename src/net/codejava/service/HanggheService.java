package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.model.Customer;
import net.codejava.model.Ghe;
import net.codejava.model.Hangghe;
import net.codejava.repository.CustomerRepository;
import net.codejava.repository.HanggheRepository;

@Service
@Transactional
public class HanggheService {
	@Autowired HanggheRepository repo;
	
	public void save(Hangghe hangghe) {
		repo.save(hangghe);
	}
	
	public List<Hangghe> listAll() {
		return (List<Hangghe>) repo.findAll();
	}
	
	public Hangghe get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
