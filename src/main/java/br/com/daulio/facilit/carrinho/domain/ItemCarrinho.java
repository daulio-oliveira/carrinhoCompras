package br.com.daulio.facilit.carrinho.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUTO_ID")
	private Produto produto;
	
	private Long quantidade;
	private Double valor;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrinho_id", referencedColumnName = "id", nullable = false)
	private Carrinho carrinho;

}
