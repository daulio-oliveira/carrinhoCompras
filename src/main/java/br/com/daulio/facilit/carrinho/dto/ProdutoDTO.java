package br.com.daulio.facilit.carrinho.dto;

import javax.validation.constraints.NotNull;

import br.com.daulio.facilit.carrinho.domain.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {

	private Long id;
	@NotNull(message = "Descrição do produto é obrigatório")
	private String descricao;
	@NotNull(message = "Valor do produto é obrigatório")
	private Double valor;
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
	}
	
	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setId(id);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		return produto;
	}
	
}
