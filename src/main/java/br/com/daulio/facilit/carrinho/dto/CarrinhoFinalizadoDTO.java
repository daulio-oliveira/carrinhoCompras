package br.com.daulio.facilit.carrinho.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.daulio.facilit.carrinho.domain.Carrinho;
import br.com.daulio.facilit.carrinho.domain.ItemCarrinho;
import lombok.Data;

@Data
public class CarrinhoFinalizadoDTO {

	@NotNull(message = "Itens é obrigatório")
	private List<ItemCarrinhoFinalizadoDTO> itens;
	
	private String cupomAplicado;
	private Double subTotal;
	private Double desconto;
	private Double total;
	
	public CarrinhoFinalizadoDTO() {
		
	}
	
	public CarrinhoFinalizadoDTO(Carrinho carrinho) {
		List<ItemCarrinhoFinalizadoDTO> itens = new ArrayList<>();
		for (ItemCarrinho item : carrinho.getItens()) {
			itens.add(new ItemCarrinhoFinalizadoDTO(item));
		}
		this.itens = itens;
		if(carrinho.getCupom() != null) {
			this.cupomAplicado = carrinho.getCupom().getCodigo();
		}
		this.subTotal = carrinho.getSubTotal();
		this.desconto = carrinho.getDesconto();
		this.total = carrinho.getTotal();
	}
}
