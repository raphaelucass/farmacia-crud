package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.Financeiro;
import br.com.farmacia.factory.ConnectionFactory;

public class FinanceiroDAO {
public void save(Financeiro financeiro) {
		
		String sql = "INSERT INTO financeiro(nome_financeiro, valor_contas, valor_imposto, lucro_mes) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, financeiro.getNome_financeiro() );
			pstm.setFloat(2, financeiro.getValor_contas());
			pstm.setFloat(3, financeiro.getValor_imposto());
			pstm.setFloat(4, financeiro.getLucro_mes());
			
			pstm.execute();
			
			System.out.println("Financeiro salvo com sucesso");
			System.out.println("=============================");
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

public void update(Financeiro financeiro) {
	
	String sql = "UPDATE financeiro SET nome_financeiro = ?, valor_contas = ?, valor_imposto = ?, lucro_mes = ? WHERE financeiro_id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, financeiro.getNome_financeiro() );
		pstm.setFloat(2, financeiro.getValor_contas());
		pstm.setFloat(3, financeiro.getValor_imposto());
		pstm.setFloat(4, financeiro.getLucro_mes());
		
		//Id do resgistro que quer atualizar
		
		pstm.setInt(5, financeiro.getFinanceiro_id());
		pstm.execute();
		
		System.out.println("Dados do financeiro atualizados com sucesso");
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
public void deleteByID(int financeiro_id) {
	String sql = "DELETE FROM financeiro WHERE financeiro_id = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	System.out.println("ID removido com sucesso");
	System.out.println("=============================");
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
	
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setInt(1, financeiro_id);
		
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

public List<Financeiro> getFinanceiro(){
	
	String sql = "SELECT * FROM financeiro";
	
	List<Financeiro> financeiro = new ArrayList<Financeiro>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()){
			Financeiro financeiro3 = new Financeiro();
			
			financeiro3.setFinanceiro_id(rset.getInt("financeiro_id"));
			financeiro3.setNome_financeiro(rset.getString("nome_financeiro"));
			financeiro3.setValor_contas(rset.getFloat("valor_contas"));
			financeiro3.setValor_imposto(rset.getFloat("valor_imposto"));
			financeiro3.setLucro_mes(rset.getFloat("lucro_mes"));
			
			financeiro.add(financeiro3);
			
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
		
		return financeiro;
	}

}

