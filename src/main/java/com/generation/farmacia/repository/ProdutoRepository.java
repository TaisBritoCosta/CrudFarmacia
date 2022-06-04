package com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.ProdutoModel;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	
	public List <ProdutoModel> findByNomeContainingIgnoreCase(@Param("nome") String nome);
	

	public List <ProdutoModel> findByNomeAndLaboratorio(String nome, String laboratorio);

	public List <ProdutoModel> findByNomeOrLaboratorio(String nome, String laboratorio);

	
	@Query(value = "select * from tb_produtos where preco between :inicio and :fim", nativeQuery = true)
	public List <ProdutoModel> buscarProdutosEntre(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);

	public List<ProdutoModel> findByPrecoIn(List<BigDecimal> preco);

}
