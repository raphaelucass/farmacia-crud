package br.com.farmacia.aplicacao;

import br.com.farmacia.Cargo;
import br.com.farmacia.dao.CargoDAO;

public class MainCargo {
	
	public static void main(String[] args) {
		
		//MAIN SEM O MENU
		
		CargoDAO cargoDao = new CargoDAO();
		
		Cargo cargo = new Cargo();
		
		cargo.setCargo_id(0);
		cargo.setGerente("");
		//CASO TENHA PREENCHIDO O GERENTE DEIXE OS OUTROS EM BRANCO
		cargo.setFarmaceutico("");
		//CASO TENHA PREENCHIDO O FARMACEUTICO DEIXE OS OUTROS EM BRANCO
		cargo.setBalconista("Davi");
		//CASO TENHA PREENCHIDO O BALCONISTA DEIXE OS OUTROS EM BRANCO
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//cargoDao.save(cargo);
	
		Cargo cargo2 = new Cargo();
		cargo2.setGerente("");
		cargo2.setFarmaceutico("Davi");
		cargo2.setBalconista("");
	
		cargo2.setCargo_id(2);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//cargoDao.update(cargo2);
		
		
		//UTILIZE // CASO NÃO QUERIA ATIVAR A FUNÇÃO
		//cargoDao.deleteByID(3);
		
		for(Cargo c : cargoDao.getCargo()){
			System.out.println("ID: "+c.getCargo_id());
			System.out.println("Gerente: "+c.getGerente());
			System.out.println("Farmaceutico: "+c.getFarmaceutico());
			System.out.println("Balconista: "+c.getBalconista());
			System.out.println("============= ");
		}
	}
}


