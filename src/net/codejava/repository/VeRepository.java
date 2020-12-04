package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.model.Ghe;
import net.codejava.model.Hoadon;
import net.codejava.model.Lichchieu;
import net.codejava.model.Ve;

public interface VeRepository extends CrudRepository<Ve, Long> {
	@Query(value = "SELECT c FROM Ve c WHERE c.ghe = :ghe "
			+ " AND c.hoadon = :hoadon ")
	public List<Ve> search(@Param("ghe") Ghe ghe,@Param("hoadon") Hoadon hoadon);
	
	public List<Ve> findByHoadon(Hoadon hoadon);

	@Query(value="SELECT v FROM Ve v WHERE v.hoadon.lichchieu = :lichchieu")
	public List<Ve> findByLichchieu(@Param("lichchieu") Lichchieu lichchieu);

	
}