package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.model.Banggia;
import net.codejava.model.Loaighe;
import net.codejava.repository.BanggiaRepository;
import net.codejava.repository.LoaigheRepository;

@Service
@Transactional
public class LoaigheService {
	@Autowired LoaigheRepository repo;
	
	public void save(Loaighe loaighe) {
		repo.save(loaighe);
	}
	
	public List<Loaighe> listAll() {
		return (List<Loaighe>) repo.findAll();
	}
	
	public Loaighe get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
