package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.model.Customer;
import net.codejava.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired CustomerRepository repo;
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public List<Customer> listAll() {
		return (List<Customer>) repo.findAll();
	}
	
	public Customer get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Customer> search(String keyword) {
		return repo.search(keyword);
	}
}
