package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.model.Ghe;
import net.codejava.model.Hangghe;

public interface HanggheRepository extends CrudRepository<Hangghe, Long> {
}
