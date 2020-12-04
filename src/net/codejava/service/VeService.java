package net.codejava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Hoadon;
import net.codejava.model.Lichchieu;
import net.codejava.model.Ve;
import net.codejava.repository.LichchieuRepository;
import net.codejava.repository.VeRepository;

@Service
@Transactional
public class VeService {
	@Autowired
	VeRepository repo;
	
	public List<Ve> findByLichchieu(Lichchieu lichchieu)
	{
		return repo.findByLichchieu(lichchieu);
	}
	
	public List<Ve> findByHoadon(Hoadon hoadon)
	{
		return repo.findByHoadon(hoadon);
	}
	
	public void save(Ve ve) {
		repo.save(ve);
	}
	
	public List<Ve> listAll() {
		return (List<Ve>) repo.findAll();
	}
	
	public Ve get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
