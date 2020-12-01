package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.model.Customer;
import net.codejava.model.Ghe;
import net.codejava.model.Hoadon;
import net.codejava.model.Ve;
import net.codejava.model.VeId;

public interface VeRepository extends CrudRepository<Ve, VeId> {
	@Query(value = "SELECT c FROM Ve c WHERE c.ghe = :ghe "
			+ " AND c.hoadon = :hoadon ")
	public List<Ve> search(@Param("ghe") Ghe ghe,@Param("hoadon") Hoadon hoadon);
	
	public List<Ve> findByHoadon(Hoadon hoadon);
}
