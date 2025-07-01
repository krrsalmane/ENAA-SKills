package com.s.demo1.repository;
import com.s.demo1.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}
