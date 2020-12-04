package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.dto.GheVeDto;
import net.codejava.model.Ghe;
import net.codejava.model.Hangghe;
import net.codejava.model.Lichchieu;
import net.codejava.repository.GheRepository;
import net.codejava.repository.HanggheRepository;

@Service
@Transactional
public class GheService {
	@Autowired GheRepository repo;
	
	public List<Ghe> findByLichchieu(Lichchieu lichchieu)
	{
		return repo.findByLichchieu(lichchieu.getPhong());
	}
	
	public List<GheVeDto> findGheVeDto(Lichchieu lichchieu)
	{
		return repo.findGheVe(lichchieu);
	}
	
	public void save(Ghe ghe) {
		repo.save(ghe);
	}
	
	public List<Ghe> listAll() {
		return (List<Ghe>) repo.findAll();
	}
	
	public Ghe get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
