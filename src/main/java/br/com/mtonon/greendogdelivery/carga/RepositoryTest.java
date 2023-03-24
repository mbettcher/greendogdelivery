package br.com.mtonon.greendogdelivery.carga;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.mtonon.greendogdelivery.domain.Cliente;
import br.com.mtonon.greendogdelivery.domain.Item;
import br.com.mtonon.greendogdelivery.domain.Pedido;
import br.com.mtonon.greendogdelivery.repositories.ClienteRepository;

@Component
public class RepositoryTest implements ApplicationRunner{
	
	private static final long ID_CLIENTE_MARCELO = 11L;
	private static final long ID_CLIENTE_DALVA = 22L;
	
	private static final long ID_ITEM1 = 100L;
	private static final long ID_ITEM2 = 101L;
	private static final long ID_ITEM3 = 102L;
	
	private static final long ID_PEDIDO1 = 1000L;
	private static final long ID_PEDIDO2 = 1001L;
	private static final long ID_PEDIDO3 = 1002L;
	
	@Autowired
	private ClienteRepository clienteRepositoy;
	
	@Override
	public void run(ApplicationArguments applicationArguments)throws Exception {
		
		System.out.println(">>> Iniciando carga de dados...");
		
		/* Cadastra 2 Clientes */
		Cliente marcelo = new Cliente(ID_CLIENTE_MARCELO,"Marcelo Tonon Bettcher","Guarapari");
    	Cliente dalva = new Cliente(ID_CLIENTE_DALVA,"Dalva Javarini","Alfredo Chaves");
    	
    	/* Cadastra 3 ítens */
    	Item dog1 = new Item(ID_ITEM1,"Green Dog tradicional",25d);
    	Item dog2 = new Item(ID_ITEM2,"Green Dog tradicional picante",27d);
		Item dog3 = new Item(ID_ITEM3,"Green Dog max salada",30d);
		
		/* Preenche 2 listas de pedidos */
		List<Item> listaPedidoMarcelo1 = new ArrayList<Item>();
		listaPedidoMarcelo1.add(dog1);
		
		List<Item> listaPedidoDalva1 = new ArrayList<Item>();
		listaPedidoDalva1.add(dog2);
		listaPedidoDalva1.add(dog3);
		
		/* Monta as listas criadas no objeto de pedido */
		Pedido pedidoDoMarcelo = new Pedido(ID_PEDIDO1, marcelo, listaPedidoMarcelo1, dog1.getPreco());
		marcelo.novoPedido(pedidoDoMarcelo);
		
		Pedido pedidoDaDalva = new Pedido(ID_PEDIDO2, dalva, listaPedidoDalva1, dog2.getPreco()+dog3.getPreco());
		dalva.novoPedido(pedidoDaDalva);
		
		System.out.println(">>> Pedido 1 - Marcelo: " + pedidoDoMarcelo);
		System.out.println(">>> Pedido 2 - Dalva: " + pedidoDaDalva);
		
		/* Persistindo dados no banco */
		clienteRepositoy.saveAndFlush(dalva);
		System.out.println(">>> Gravando o cliente 2: " + dalva);
		
		List<Item> listaPedidoMarcelo2 = new ArrayList<>();
		listaPedidoMarcelo2.add(dog2);
		Pedido pedido2DoMarcelo = new Pedido(ID_PEDIDO3, marcelo, listaPedidoMarcelo2, dog2.getPreco());
		marcelo.novoPedido(pedido2DoMarcelo);
		clienteRepositoy.saveAndFlush(marcelo);
		System.out.println(">>> Gravand Pedido 2 - Marcelo: " + pedido2DoMarcelo);
		System.out.println(">>> Gravando o cliente 1: " + marcelo);
		
	}

}
