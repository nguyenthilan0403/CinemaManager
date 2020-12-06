package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.model.Ghe;
import net.codejava.model.Hangghe;
import net.codejava.model.Lichchieu;
import net.codejava.model.Phim;
import net.codejava.model.Phong;
import net.codejava.model.Ve;

public interface LichchieuRepository extends CrudRepository<Lichchieu, Long> {

//	@Query(value="SELECT hg FROM Hangghe hg, :lichchieu lc WHERE hg.phong = lc.phong")
//	public List<Hangghe> getHangghe(@Param("lichchieu") Lichchieu lichchieu);
	
	
//	public List<Lichchieu> findByPhim(Phim phim);

	@Query(value="SELECT lc FROM Lichchieu lc WHERE lc.phim = :phim")
	public List<Lichchieu> findByPhim( @Param("phim") Phim phim);
	
	 @Query(value="SELECT lc FROM Lichchieu lc WHERE lc.phim = :phim AND CONCAT(lc.ngaychieu, ' ', lc.giochieu) > NOW()")
	 public List<Lichchieu> getLichChieuTuongLai( @Param("phim") Phim phim);
}