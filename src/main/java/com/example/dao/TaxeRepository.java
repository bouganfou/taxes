package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Entreprise;
import com.example.entities.Taxe;

public interface TaxeRepository  extends JpaRepository<Taxe, Long>{
	@Query("select t from Taxe t where t.titre like :x")
	public Page<Taxe> chercher(@Param("x")String mc,Pageable pageable);
	
	public List<Taxe> findByEntreprise(Entreprise e);
}
