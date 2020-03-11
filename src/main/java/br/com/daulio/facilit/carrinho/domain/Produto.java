package br.com.daulio.facilit.carrinho.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descricao;
	private Double valor;
	
	@OneToOne(mappedBy = "produto", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
	private ItemCarrinho item;
}
