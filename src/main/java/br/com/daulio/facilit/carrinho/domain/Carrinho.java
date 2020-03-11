package br.com.daulio.facilit.carrinho.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "carrinho", fetch = FetchType.LAZY)
	private List<ItemCarrinho> itens;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CUPOM", referencedColumnName = "ID")
	private Cupom cupom;
	
	private Double subTotal;
	private Double desconto;
	private Double total;
	
	
}
