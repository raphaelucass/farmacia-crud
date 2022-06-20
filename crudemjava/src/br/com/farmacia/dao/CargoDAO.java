package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.Cargo;
import br.com.farmacia.factory.ConnectionFactory;

public class CargoDAO {
public void save(Cargo cargo) {
		
		String sql = "INSERT INTO cargo(gerente, farmaceutico, balconista) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, cargo.getGerente());
			pstm.setString(2, cargo.getFarmaceutico());
			pstm.setString(3, cargo.getBalconista());
			
			pstm.execute();
			
			System.out.println("Cargo salvo com sucesso");
			System.out.println("=======================");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
public void update(Cargo cargo) {
	
	String sql = "UPDATE cargo SET gerente = ?, farmaceutico = ?, balconista = ? WHERE cargo_id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, cargo.getGerente());
		pstm.setString(2, cargo.getFarmaceutico());
		pstm.setString(3, cargo.getBalconista());
		
		//Id do resgistro que quer atualizar
		pstm.setInt(4, cargo.getCargo_id());
		pstm.execute();
		
		System.out.println("Cargo atualizado com sucesso");
		System.out.println("=============================");
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if (pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public void deleteByID(int cargo_id) {
	String sql = "DELETE FROM cargo WHERE cargo_id = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	System.out.println("Cargo removido com sucesso");
	System.out.println("==========================");
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
	
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setInt(1, cargo_id);
		
		pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if (pstm != null) {
				pstm.close();
				}
			if (conn != null) {
				conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

public List<Cargo> getCargo(){
	
	String sql = "SELECT * FROM cargo";
	
	List<Cargo> cargo = new ArrayList<Cargo>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()){
			Cargo cargo2 = new Cargo();
			
			cargo2.setCargo_id(rset.getInt("cargo_id"));
			cargo2.setGerente(rset.getString("gerente"));
			cargo2.setFarmaceutico(rset.getString("farmaceutico"));
			cargo2.setBalconista(rset.getString("balconista"));
			
			cargo.add(cargo2);
			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return cargo;
	}
}
