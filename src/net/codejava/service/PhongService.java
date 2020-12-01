package net.codejava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Phim;
import net.codejava.model.Phong;
import net.codejava.repository.PhongRepository;

@Service
@Transactional
public class PhongService {
	@Autowired
	PhongRepository repo;
	
	public void save(Phong phong)
	{
		repo.save(phong);
	}
	
	public List<Phong> listAll() {
		return (List<Phong>) repo.findAll();
	}
	
	public Phong get(Long id)
	{
		return repo.findById(id).get();
	}
	
	public void delete(Long id)
	{
		repo.deleteById(id);
	}
}
