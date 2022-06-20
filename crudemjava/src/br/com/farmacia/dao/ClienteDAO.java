package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.Cliente;
import br.com.farmacia.factory.ConnectionFactory;

public class ClienteDAO {
	
public void save(Cliente cliente) {
		
		String sql = "INSERT INTO cliente (nome, sobrenome, email, endereco, n_endereco, telefone) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome() );
			pstm.setString(2, cliente.getSobrenome());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getEndereco());
			pstm.setInt(5, cliente.getN_endereco());
			pstm.setInt(6, cliente.getTelefone());
			
			pstm.execute();
			
			System.out.println("Cliente salvo com sucesso");
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

public void update(Cliente cliente) {
	
	String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, email = ?, endereco = ?, n_endereco = ?, telefone = ? WHERE cliente_id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, cliente.getNome() );
		pstm.setString(2, cliente.getSobrenome());
		pstm.setString(3, cliente.getEmail());
		pstm.setString(4, cliente.getEndereco());
		pstm.setInt(5, cliente.getN_endereco());
		pstm.setInt(6, cliente.getTelefone());
		
		//Id do resgistro que quer atualizar
		
		pstm.setInt(7, cliente.getCliente_id());
		pstm.execute();
		
		System.out.println("Dados do cliente atualizados com sucesso");
		System.out.println("==========================-----------===");
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
public void deleteByID(int cliente_id) {
	String sql = "DELETE FROM cliente WHERE cliente_id = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	System.out.println("ID do cliente removido com sucesso");
	System.out.println("=============================");
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
	
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setInt(1, cliente_id);
		
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

public List<Cliente> getCliente(){
	
	String sql = "SELECT * FROM cliente";
	
	List<Cliente> cliente = new ArrayList<Cliente>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()){
			Cliente cliente3 = new Cliente();
			
			cliente3.setCliente_id(rset.getInt("cliente_id"));
			cliente3.setNome(rset.getString("nome"));
			cliente3.setSobrenome(rset.getString("sobrenome"));
			cliente3.setEmail(rset.getString("email"));
			cliente3.setEndereco(rset.getString("endereco"));
			cliente3.setN_endereco(rset.getInt("n_endereco"));
			cliente3.setTelefone(rset.getInt("telefone"));

			cliente.add(cliente3);
			
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
		
		return cliente;
	}
}
