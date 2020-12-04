package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.model.Banggia;
import net.codejava.repository.BanggiaRepository;

@Service
@Transactional
public class BanggiaService {
	@Autowired BanggiaRepository repo;
	
	public void save(Banggia banggia) {
		repo.save(banggia);
	}
	
	public List<Banggia> listAll() {
		return (List<Banggia>) repo.findAll();
	}
	
	public Banggia get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
