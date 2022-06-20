package br.com.farmacia.aplicacao;

import br.com.farmacia.Cliente;
import br.com.farmacia.dao.ClienteDAO;

public class MainCliente {
	
	public static void main(String[] args) {
	
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente cliente = new Cliente();
	
	cliente.setCliente_id(1);
	cliente.setNome("Lucas");
	cliente.setSobrenome("Raphael");
	cliente.setEmail("lucas@gmail.com");
	cliente.setEndereco("QNL 6 Conjunto D");
	cliente.setN_endereco(2);
	cliente.setTelefone(992514673);
	
	//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
	//clienteDao.save(cliente);

	Cliente cliente2 = new Cliente();
	cliente2.setNome("Vitor");
	cliente2.setSobrenome("Baby");
	cliente2.setEmail("baby@gmail.com");
	cliente2.setEndereco("CSA 1 Lote 2");
	cliente2.setN_endereco(3);
	cliente2.setTelefone(994918414);
	
	
	cliente2.setCliente_id(1); //Número que está no banco de dados
	
	//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
	//clienteDao.update(cliente2);
	
	//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
	//clienteDao.deleteByID(1);
	
	for(Cliente c : clienteDao.getCliente()) {
		System.out.println("ID do cliente: "+c.getCliente_id());
		System.out.println("Nome do cliente: "+c.getNome());
		System.out.println("Sobrenome do cliente: "+c.getSobrenome());
		System.out.println("Email: "+c.getEmail());
		System.out.println("Endereco: "+c.getEndereco());
		System.out.println("Numero: "+c.getN_endereco());
		System.out.println("Telefone: "+c.getTelefone());
		System.out.println("=====================");
		}
	}
}

