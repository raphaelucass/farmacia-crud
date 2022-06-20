package br.com.farmacia;

public class Financeiro {
	
	private int financeiro_id;
	private String nome_financeiro;
	private float valor_contas;
	private float valor_imposto;
	private float lucro_mes;
	
	public int getFinanceiro_id() {
		return financeiro_id;
	}
	public void setFinanceiro_id(int financeiro_id) {
		this.financeiro_id = financeiro_id;
	}
	public String getNome_financeiro() {
		return nome_financeiro;
	}
	public void setNome_financeiro(String nome_financeiro) {
		this.nome_financeiro = nome_financeiro;
	}
	public float getValor_contas() {
		return valor_contas;
	}
	public void setValor_contas(float valor_contas) {
		this.valor_contas = valor_contas;
	}
	public float getValor_imposto() {
		return valor_imposto;
	}
	public void setValor_imposto(float valor_imposto) {
		this.valor_imposto = valor_imposto;
	}
	public float getLucro_mes() {
		return lucro_mes;
	}
	public void setLucro_mes(float lucro_mes) {
		this.lucro_mes = lucro_mes;
	}
	
}
