package br.com.mtonon.greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mtonon.greendogdelivery.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
