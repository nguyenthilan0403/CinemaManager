package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.model.Ghe;
import net.codejava.model.Lichchieu;
import net.codejava.model.Phong;

public interface GheRepository extends CrudRepository<Ghe, Long> {

	@Query(value="SELECT g FROM Ghe g WHERE g.hangghe.phong = :phong")
	public List<Ghe> findByLichchieu(@Param("phong") Phong phong);
}
