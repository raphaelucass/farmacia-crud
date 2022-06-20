package br.com.farmacia.aplicacao;

import br.com.farmacia.Financeiro;
import br.com.farmacia.dao.FinanceiroDAO;

public class MainFinanceiro {
	
	public static void main(String[] args) {
		
		//MAIN SEM O MENU
		
		FinanceiroDAO financeiroDao = new FinanceiroDAO();
		
		Financeiro financeiro = new Financeiro();
		
		financeiro.setFinanceiro_id(1);
		financeiro.setNome_financeiro("Ebanx");
		financeiro.setValor_contas((float) 200.11);
		financeiro.setValor_imposto((float) 97.91);
		financeiro.setLucro_mes((float) 2097.91);
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//financeiroDao.save(financeiro);
		
		Financeiro financeiro2 = new Financeiro();
		financeiro2.setNome_financeiro("Intermediário");
		financeiro2.setValor_contas((float)199.99);
		financeiro2.setValor_imposto((float) 97.91);
		financeiro2.setLucro_mes((float) 2097.91);
		financeiro2.setFinanceiro_id(1); //Número que está no banco de dados
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//financeiroDao.update(financeiro2);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//financeiroDao.deleteByID(2);
		
		for(Financeiro c : financeiroDao.getFinanceiro()) {
			System.out.println("ID do financeiro: "+c.getFinanceiro_id());
			System.out.println("Nome do financeiro: "+c.getNome_financeiro());
			System.out.println("Valor das contas: "+c.getValor_contas());
			System.out.println("Valor dos impostos: "+c.getValor_imposto());
			System.out.println("Lucro do Mes: "+c.getLucro_mes());
			System.out.println("===========================");
		}
		
	}
}
