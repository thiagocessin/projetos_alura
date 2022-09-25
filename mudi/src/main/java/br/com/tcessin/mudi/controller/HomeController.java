package br.com.tcessin.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.tcessin.mudi.model.Pedido;

@Controller
public class HomeController {

	
	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Celular Xiaomi Redmi");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/911TJ1CDbLL._AC_SX425_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Celular-Xiaomi-Redmi-Activ-128Gb/dp/B09GFP6XHG/ref=sr_1_1?adgrpid=123470245170&gclid=CjwKCAjw-L-ZBhB4EiwA76YzOf6-Nhy_MlK8iKOrYAlsmGUH1cwFLbQqN8j-Fca4-HPz_Bg1EqOlrRoCUvUQAvD_BwE&hvadid=593184093484&hvdev=c&hvlocphy=1001773&hvnetw=g&hvqmt=e&hvrand=996955524546472502&hvtargid=kwd-533504558841&hydadcr=17157_13443052&keywords=xiaomi+amazon&qid=1664115211&qu=eyJxc2MiOiIzLjg3IiwicXNhIjoiMy4wNCIsInFzcCI6IjEuMDAifQ%3D%3D&sr=8-1&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
		pedido.setDescricao("Descrição");
		pedido.setDataEntrega(LocalDate.now());
		pedido.setValorNegociado(new BigDecimal(500));
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos",pedidos);
		
		
		return "home";
	}
	
}
