package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.model.Hangghe;
import net.codejava.model.Lichchieu;

public interface LichchieuRepository extends CrudRepository<Lichchieu, Long> {

//	@Query(value="SELECT hg FROM Hangghe hg, :lichchieu lc WHERE hg.phong = lc.phong")
//	public List<Hangghe> getHangghe(@Param("lichchieu") Lichchieu lichchieu);
}