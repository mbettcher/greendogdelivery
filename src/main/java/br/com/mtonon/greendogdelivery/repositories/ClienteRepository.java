package br.com.mtonon.greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mtonon.greendogdelivery.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
