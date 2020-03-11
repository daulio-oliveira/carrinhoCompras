package br.com.daulio.facilit.carrinho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.daulio.facilit.carrinho.domain.Cupom;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
	
	Optional<Cupom> findByCodigo(String codigo);
	
}
