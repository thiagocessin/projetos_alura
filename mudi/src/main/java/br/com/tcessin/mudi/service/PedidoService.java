package br.com.tcessin.mudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcessin.mudi.model.Pedido;
import br.com.tcessin.mudi.repository.PedidoRepository;

@Service
public class PedidoService {
	
	
	@Autowired
	private PedidoRepository repo;
	
	
	public List<Pedido> findAll(){
		return repo.findAll();
	}
	
	
	

}
