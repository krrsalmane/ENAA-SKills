package com.s.demo1.repository;

import com.s.demo1.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant,Long> {
}
