package br.com.farmacia.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.farmacia.Medicamento;
import br.com.farmacia.dao.MedicamentoDAO;

public class MainControleDeEstoqueMedicamentos {

	public static void main(String[] args) {
		
		//MAIN COM O MENU
		
		System.out.println("========================");
		System.out.println("Bem vindo ao sistema de farmacia Raphael e Davi");
		System.out.println("========================");
		
		Scanner s = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		Scanner s3 = new Scanner(System.in);
		
		
		MedicamentoDAO farmaciaDao = new MedicamentoDAO();
		Medicamento medicamento = new Medicamento();
		
		int ch = 0;
		do {
			System.out.println("1 Para inserir um novo medicamento");
			System.out.println("2 Para editar um medicamento");
			System.out.println("3 Para remover um medicamento");
			System.out.println("4 Para ver a lista de medicamentos");
			ch = s.nextInt();
			
			switch(ch) {
			case 1:
				
				medicamento.setId(1);
				
				System.out.println("Qual o nome do laboratorio?");
				medicamento.setNome_laboratorio(s.next());
				medicamento.setDt_vencimento(new Date());
				System.out.println("Qual o preco do medicamento?");
				medicamento.setPreco(s.nextFloat());
				System.out.println("Qual o nome do medicamento?");
				medicamento.setNome_medicamento(s2.nextLine());
				System.out.println("Digite a quantidade em estoque");
				medicamento.setQtd_estoque(s.nextInt());
				
				farmaciaDao.save(medicamento);
				
			break;
			
			case 2:
				
				Medicamento f1 = new Medicamento();
				
				System.out.println("Digite o ID do medicamento: ");
				f1.setId(s3.nextInt()); //Número que está no banco de dados
				
				System.out.println("Digite o novo nome do laboratorio:");
				f1.setNome_laboratorio(s3.next());
				
				System.out.println("Digite o novo nome do medicamento: ");
				f1.setNome_medicamento(s3.next());
				
				System.out.println("Digite o novo preco do medicamento: ");
				f1.setPreco(s3.nextFloat());
				
				System.out.println("Digite a nova quantidade em estoque: ");
				f1.setQtd_estoque(s3.nextInt());
				
				f1.setDt_vencimento(new Date());
				
				farmaciaDao.update(f1);
				
				break;
				
			case 3:
				
				System.out.println("Digite o ID do medicamento que deseja deletar: ");
				farmaciaDao.deleteByID(s2.nextInt());

				break;
				
			case 4:
				for
					(Medicamento c : farmaciaDao.getMedicamentos()) {
					
					
					System.out.println("Digite o ID do medicamento: ");
					c.setId(s3.nextInt());
							
					System.out.println("Nome do laboratorio: "+c.getNome_laboratorio());
					System.out.println("Nome do medicamento: "+c.getNome_medicamento());
					System.out.println("Preco: "+c.getPreco());
					System.out.println("Estoque: "+c.getQtd_estoque());
					System.out.println("=============================");
				}
				break;
			} 
		}while(ch!=0);
		
		}
	}


