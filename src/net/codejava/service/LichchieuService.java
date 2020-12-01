package net.codejava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Lichchieu;
import net.codejava.repository.LichchieuRepository;

@Service
@Transactional
public class LichchieuService {
	@Autowired
	LichchieuRepository repo;
	
	
	public void save(Lichchieu lichchieu) {
		repo.save(lichchieu);
	}
	
	public List<Lichchieu> listAll() {
		return (List<Lichchieu>) repo.findAll();
	}
	
	public Lichchieu get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
