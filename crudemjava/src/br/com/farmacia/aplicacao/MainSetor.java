package br.com.farmacia.aplicacao;

import br.com.farmacia.Setor;
import br.com.farmacia.dao.SetorDAO;

public class MainSetor {
	
	public static void main(String[] args) {
		
		//MAIN SEM O MENU
		
		SetorDAO SetorDao = new SetorDAO();
		
		Setor setor = new Setor();
		
		setor.setSetor_id(1);
		setor.setNome_setor("Perfumes");
		setor.setQtdmed_setor(9);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//SetorDao.save(setor);
	
		Setor setor2 = new Setor();
		setor2.setNome_setor("Tarjas preta");
		setor2.setQtdmed_setor(11);
		setor2.setSetor_id(1);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//SetorDao.update(setor2);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//SetorDao.deleteByID(2);
		
		for(Setor c : SetorDao.getSetor()) {
			System.out.println("Nome do Setor: "+c.getNome_setor());
		}
	}
}
