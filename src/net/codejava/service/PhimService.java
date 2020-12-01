package net.codejava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Phim;
import net.codejava.repository.PhimRepository;

@Service
@Transactional
public class PhimService {
	@Autowired
	PhimRepository repo;
	
	public void save(Phim phim)
	{
		repo.save(phim);
	}
	
	public List<Phim> listAll() {
		return (List<Phim>) repo.findAll();
	}
	
	public Phim get(Long id)
	{
		return repo.findById(id).get();
	}
	
	public void delete(Long id)
	{
		repo.deleteById(id);
	}
}
