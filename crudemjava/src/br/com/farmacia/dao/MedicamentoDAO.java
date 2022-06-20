package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.Medicamento;
import br.com.farmacia.factory.ConnectionFactory;

public class MedicamentoDAO {
	
public void save(Medicamento medicamento) {
		
		String sql = "INSERT INTO medicamentos(nome_laboratorio, preco, dt_vencimento, nome_medicamento, qtd_estoque) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, medicamento.getNome_laboratorio());
			pstm.setFloat(2, medicamento.getPreco());
			pstm.setDate(3, new Date(medicamento.getDt_vencimento().getTime()));
			pstm.setString(4, medicamento.getNome_medicamento());
			pstm.setInt(5, medicamento.getQtd_estoque());
			
			pstm.execute();
			
			System.out.println("Medicamento salvo com sucesso");
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
		public void update(Medicamento medicamento) {
			
			String sql = "UPDATE medicamentos SET nome_laboratorio = ?, preco = ?, nome_medicamento = ?, dt_vencimento = ?, qtd_estoque = ? WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setString(1, medicamento.getNome_laboratorio());
				pstm.setFloat(2, medicamento.getPreco());
				pstm.setString(3, medicamento.getNome_medicamento());
				pstm.setDate(4, new Date(medicamento.getDt_vencimento().getTime()));
				pstm.setInt(5, medicamento.getQtd_estoque());
				
				//Id do resgistro que quer atualizar
				pstm.setInt(6, medicamento.getId());
				pstm.execute();
				
				System.out.println("Medicamento atualizados com sucesso");
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
		
		public void deleteByID(int id) {
			String sql = "DELETE FROM farmacia.medicamentos WHERE id = ?";
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
			
			System.out.println("ID removido com sucesso");
			System.out.println("=============================");
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
			
				pstm = (PreparedStatement)conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
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

	public List<Medicamento> getMedicamentos(){
		
		String sql = "SELECT * FROM farmacia.medicamentos";
		
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()){
				Medicamento medicamento = new Medicamento();
				
				medicamento.setId(rset.getInt("id"));
				medicamento.setNome_laboratorio(rset.getString("nome_laboratorio"));
				medicamento.setNome_medicamento(rset.getString("nome_medicamento"));
				medicamento.setPreco(rset.getFloat("preco"));
				medicamento.setQtd_estoque(rset.getInt("qtd_estoque"));
				medicamento.setDt_vencimento(rset.getDate("dt_vencimento"));
				
				medicamentos.add(medicamento);
				
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
			
			return medicamentos;
	}
}
