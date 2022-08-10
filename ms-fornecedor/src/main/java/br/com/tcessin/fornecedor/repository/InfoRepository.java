package br.com.tcessin.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tcessin.fornecedor.model.InfoFornecedor;

public interface InfoRepository extends CrudRepository<InfoFornecedor, Long>{

	InfoFornecedor findByEstado(String estado);
	
}
