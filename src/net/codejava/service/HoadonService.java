package net.codejava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Ghe;
import net.codejava.model.Hangghe;
import net.codejava.model.Hoadon;
import net.codejava.model.Lichchieu;
import net.codejava.model.Phim;
import net.codejava.repository.HoadonRepository;
import net.codejava.repository.LichchieuRepository;

@Service
@Transactional
public class HoadonService {
	@Autowired HoadonRepository repo;
	
	public void save(Hoadon hoadon) {
		repo.save(hoadon);
	}
	
	public List<Hoadon> listAll() {
		return (List<Hoadon>) repo.findAll();
	}
	
	public Hoadon get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
