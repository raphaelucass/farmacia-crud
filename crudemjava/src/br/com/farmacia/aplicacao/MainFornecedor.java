package br.com.farmacia.aplicacao;

import br.com.farmacia.Fornecedor;

import br.com.farmacia.dao.FornecedorDAO;

public class MainFornecedor {
	
	public static void main(String[] args) {
		
		//MAIN SEM O MENU
		
		FornecedorDAO FornecedorDao = new FornecedorDAO();
		
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setFornecedor_id(1);
		fornecedor.setNome_fornecedor("Medicamentos RD");
		fornecedor.setPreco((float)(85.99));
		fornecedor.setProd_fornecido("Multigrip");
		fornecedor.setQuantidade(50);
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//FornecedorDao.save(fornecedor);
		
		Fornecedor fornecedor2 = new Fornecedor();
		fornecedor2.setNome_fornecedor("RDMedicamentos");
		fornecedor2.setPreco((float)(89.99));
		fornecedor2.setProd_fornecido("Dipirona");
		fornecedor2.setQuantidade(30);
		fornecedor2.setFornecedor_id(1); //ID pra mudar no banco de dados
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//FornecedorDao.update(fornecedor2);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//FornecedorDao.deleteByID(2);
		
		for(Fornecedor c : FornecedorDao.getFornecedor()) {
			System.out.println("Nome fornecedor: " + c.getNome_fornecedor());
		}

		
	}

}
