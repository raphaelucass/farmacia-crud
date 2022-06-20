package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.Funcionario;
import br.com.farmacia.factory.ConnectionFactory;

public class FuncionarioDAO {

public void save(Funcionario funcionario) {
		
		String sql = "INSERT INTO funcionario(nome, cpf, cargo, salario) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, funcionario.getNome());
			pstm.setFloat(2, funcionario.getCpf());
			pstm.setString(3, funcionario.getCargo());
			pstm.setFloat(4, funcionario.getSalario());
			
			pstm.execute();
			
			System.out.println("Funcionario salvo com sucesso");
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

public void update(Funcionario funcionario) {
	
	String sql = "UPDATE funcionario SET nome = ?, cpf = ?, cargo = ?, salario = ? WHERE funcionario_id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, funcionario.getNome());
		pstm.setFloat(2, funcionario.getCpf());
		pstm.setString(3, funcionario.getCargo());
		pstm.setFloat(4, funcionario.getSalario());
		
		//Id do resgistro que quer atualizar
		pstm.setInt(5, funcionario.getFuncionario_id());
		pstm.execute();
		
		System.out.println("Dados do funcionario atualizados com sucesso");
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
public void deleteByID(int funcionario_id) {
	String sql = "DELETE FROM funcionario WHERE funcionario_id = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	System.out.println("ID removido com sucesso");
	System.out.println("=======================");
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
	
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setInt(1, funcionario_id);
		
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

public List<Funcionario> getFuncionario(){
	
	String sql = "SELECT * FROM funcionario";
	
	List<Funcionario> funcionario = new ArrayList<Funcionario>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()){
			Funcionario funcionario3 = new Funcionario();
			
			funcionario3.setFuncionario_id(rset.getInt("funcionario_id"));
			funcionario3.setNome(rset.getString("nome"));
			funcionario3.setCpf(rset.getInt("cpf"));
			funcionario3.setCargo(rset.getString("cargo"));
			funcionario3.setSalario(rset.getFloat("salario"));
			
			funcionario.add(funcionario3);
			
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
		
		return funcionario;
	}

}
