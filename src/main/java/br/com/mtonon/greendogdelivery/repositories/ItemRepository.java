package br.com.mtonon.greendogdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mtonon.greendogdelivery.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
