package br.com.daulio.facilit.carrinho.dto;

import javax.validation.constraints.NotNull;

import br.com.daulio.facilit.carrinho.domain.ItemCarrinho;
import br.com.daulio.facilit.carrinho.domain.Produto;
import br.com.daulio.facilit.carrinho.exception.ApiException;
import br.com.daulio.facilit.carrinho.service.ProdutoService;
import lombok.Data;

@Data
public class ItemCarrinhoDTO {
	
	@NotNull(message = "Id do produto é obrigatório")
	private Long idProduto;
	private Long quantidade;
	
    public ItemCarrinho toItemCarrinho(ProdutoService produtoService) throws ApiException {  	
    	Produto produto = new Produto(); 
    	produto = produtoService.buscarPorId(idProduto).toProduto();
    	ItemCarrinho item = new ItemCarrinho();
    	item.setProduto(produto);
    	item.setQuantidade(this.quantidade);
    	
    	Double valor = produto.getValor() * this.quantidade;	
    	if(this.quantidade >= 10) {
    		Double valorPerc = valor*0.10;
    		item.setValor(valor-valorPerc);
    	}else {
    		item.setValor(valor);
    	}
    	
    	return item;
    	
    }
}
