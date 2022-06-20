package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.Setor;
import br.com.farmacia.factory.ConnectionFactory;

public class SetorDAO {

public void save(Setor setor) {
		
		String sql = "INSERT INTO setor(nome_setor, qtdmed_setor) VALUES (?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, setor.getNome_setor());
			pstm.setInt(2, setor.getQtdmed_setor());
			
			pstm.execute();
			
			System.out.println("Setor salvo com sucesso");
			System.out.println("========================");
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
public void update(Setor setor) {
	
	String sql = "UPDATE setor SET nome_setor = ?, qtdmed_setor = ? WHERE setor_id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, setor.getNome_setor());
		pstm.setInt(2, setor.getQtdmed_setor());
		
		//Id do resgistro que quer atualizar
		pstm.setInt(3, setor.getSetor_id());
		pstm.execute();
		
		System.out.println("Setor atualizado com sucesso");
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
public void deleteByID(int setor_id) {
	String sql = "DELETE FROM setor WHERE setor_id = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	System.out.println("ID removido com sucesso");
	System.out.println("=======================");
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
	
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setInt(1, setor_id);
		
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

public List<Setor> getSetor(){
	
	String sql = "SELECT * FROM setor";
	
	List<Setor> setor = new ArrayList<Setor>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()){
			Setor setor2 = new Setor();
			
			setor2.setSetor_id(rset.getInt("setor_id"));
			setor2.setNome_setor(rset.getString("nome_setor"));
			setor2.setQtdmed_setor(rset.getInt("qtdmed_setor"));
			
			setor.add(setor2);
			
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
		
		return setor;
	}
}
