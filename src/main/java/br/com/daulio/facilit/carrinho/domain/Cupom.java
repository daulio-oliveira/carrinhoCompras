package br.com.daulio.facilit.carrinho.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cupom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private Long id;
	
	@Column(name="CD_CUPOM")
	private String codigo;
	
	private String descricao;
	private Double percentual;
	
}
