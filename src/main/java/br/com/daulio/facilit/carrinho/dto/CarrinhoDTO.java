package br.com.daulio.facilit.carrinho.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.daulio.facilit.carrinho.domain.Carrinho;
import br.com.daulio.facilit.carrinho.domain.Cupom;
import br.com.daulio.facilit.carrinho.domain.ItemCarrinho;
import br.com.daulio.facilit.carrinho.exception.ApiException;
import br.com.daulio.facilit.carrinho.service.ProdutoService;
import lombok.Data;

@Data
public class CarrinhoDTO {
	private List<String> cupons;
	@NotNull(message = "Itens é obrigatório")
	private List<ItemCarrinhoDTO> itens;
	
	public Carrinho toCarrinho(Cupom cupom, ProdutoService produtoService) throws ApiException {
		Carrinho carrinho = new Carrinho();
		List<ItemCarrinho> itensList = new ArrayList<ItemCarrinho>();
		
		Double subTotal = 0.0;
		for (ItemCarrinhoDTO item : this.itens) {
			ItemCarrinho itemCar = item.toItemCarrinho(produtoService);
			itensList.add(itemCar);
			subTotal += itemCar.getValor();
		}
		carrinho.setItens(itensList);
		
		Double desconto = calcDescontoProgressivo(subTotal);
		Double total = subTotal - desconto;
		if(cupom != null) {
			desconto += calcDescontoCupom(cupom, subTotal);
			total -= desconto;
		}	

		carrinho.setDesconto(desconto);	
		carrinho.setSubTotal(subTotal);
		carrinho.setTotal(total);
		if(cupom != null && cupom.getCodigo() != null) {
			carrinho.setCupom(cupom);
		}
		
		return carrinho;
	}
	
	private Double calcDescontoCupom(Cupom cupom, Double subTotal) {
		if(cupom.getPercentual() > 0) {
			return subTotal * (cupom.getPercentual()/100);
		}
		return 0.0;
	}

	private Double calcDescontoProgressivo(Double subTotal) {
		if(subTotal >= 1000 && subTotal < 5000) {
			return subTotal * 0.05;
		}else if(subTotal >= 5000 && subTotal < 10000) {
			return subTotal * 0.07;
		}else if(subTotal >= 10000) {
			return subTotal * 0.10;
		}
		return 0.0;
	}

}
