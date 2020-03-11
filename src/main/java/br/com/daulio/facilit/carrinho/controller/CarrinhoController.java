package br.com.daulio.facilit.carrinho.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daulio.facilit.carrinho.dto.CarrinhoDTO;
import br.com.daulio.facilit.carrinho.dto.CarrinhoFinalizadoDTO;
import br.com.daulio.facilit.carrinho.service.CarrinhoService;
import io.swagger.annotations.Api;

@RestController()
@RequestMapping("/carrinho")
@Api(value = "API Carrinho de compras", tags = { "Carrinho" })
public class CarrinhoController {
	
	@Autowired private CarrinhoService service;
	
	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> salvarCarrinho(@RequestBody @Valid CarrinhoDTO dto) 
			throws Exception {
		
		CarrinhoFinalizadoDTO carrinho = service.salvar(dto);
		return new ResponseEntity<>(carrinho, HttpStatus.CREATED);
	}

}
