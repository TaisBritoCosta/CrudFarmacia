package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.CategoriaModel;


public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	public List <CategoriaModel> findAllByNomeContainingIgnoreCase(@Param("tipo") String nome);

}