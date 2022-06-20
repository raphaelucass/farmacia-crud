package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.Fornecedor;
import br.com.farmacia.factory.ConnectionFactory;

public class FornecedorDAO {
	
public void save(Fornecedor fornecedor) {
		
		String sql = "INSERT INTO fornecedor(nome_fornecedor, preco, prod_fornecido, quantidade) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, fornecedor.getNome_fornecedor());
			pstm.setFloat(2, fornecedor.getPreco());
			pstm.setString(3, fornecedor.getProd_fornecido());
			pstm.setInt(4, fornecedor.getQuantidade());
			
			pstm.execute();
			
			System.out.println("Fornecedor salvo com sucesso");
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

public void update(Fornecedor fornecedor) {
	
	String sql = "UPDATE fornecedor SET nome_fornecedor = ?, preco = ?, prod_fornecido = ?, quantidade = ? WHERE fornecedor_id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, fornecedor.getNome_fornecedor());
		pstm.setFloat(2, fornecedor.getPreco());
		pstm.setString(3, fornecedor.getProd_fornecido());
		pstm.setInt(4, fornecedor.getQuantidade());
		
		//Id do resgistro que quer atualizar
		pstm.setInt(5, fornecedor.getFornecedor_id());
		pstm.execute();
		
		System.out.println("Fornecedor atualizado com sucesso");
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
public void deleteByID(int fornecedor_id) {
	String sql = "DELETE FROM fornecedor WHERE fornecedor_id = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	System.out.println("ID removido com sucesso");
	System.out.println("=============================");
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
	
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setInt(1, fornecedor_id);
		
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

public List<Fornecedor> getFornecedor(){
	
	String sql = "SELECT * FROM fornecedor";
	
	List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()){
			Fornecedor fornecedor3 = new Fornecedor();
			
			fornecedor3.setFornecedor_id(rset.getInt("fornecedor_id"));
			fornecedor3.setNome_fornecedor(rset.getString("nome_fornecedor"));
			fornecedor3.setPreco(rset.getFloat("preco"));
			fornecedor3.setProd_fornecido(rset.getString("prod_fornecido"));
			fornecedor3.setQuantidade(rset.getInt("quantidade"));
			
			fornecedor.add(fornecedor3);
			
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
		
		return fornecedor;
	}

}
