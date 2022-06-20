package br.com.farmacia.aplicacao;

import br.com.farmacia.Funcionario;
import br.com.farmacia.dao.FuncionarioDAO;

public class MainFuncionario {

	public static void main(String[] args) {
		
		//MAIN SEM O MENU
		
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setFuncionario_id(1);
		funcionario.setNome("Davi");
		funcionario.setCpf(123456789);
		funcionario.setCargo("Gerente");
		funcionario.setSalario((float)2199.99);
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//funcionarioDao.save(funcionario);
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Baby");
		funcionario2.setCpf(87742810);
		funcionario2.setCargo("Gerente");
		funcionario2.setSalario((float)2299.99);
		funcionario2.setFuncionario_id(2); //ID pra mudar no banco de dados
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//funcionarioDao.update(funcionario2);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//funcionarioDao.deleteByID(2);
		
		for(Funcionario c : funcionarioDao.getFuncionario()) {
			System.out.println("Nome: " + c.getNome());
			System.out.println("CPF: " + c.getCpf());
			System.out.println("Cargo: " + c.getCargo());
			System.out.println("Salario: " + c.getSalario());
		}

		
	}

}
