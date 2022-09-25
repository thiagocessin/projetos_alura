package br.com.tcessin.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.tcessin.mudi.model.Pedido;
import br.com.tcessin.mudi.service.PedidoService;

@Controller
public class HomeController {

	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/home")
	public String home(Model model) {
		
	
		List<Pedido> pedidos = pedidoService.findAll();
		model.addAttribute("pedidos",pedidos);
		
		
		return "home";
	}
	
}
