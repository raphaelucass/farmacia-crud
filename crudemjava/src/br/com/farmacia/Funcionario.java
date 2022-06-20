package br.com.farmacia;

public class Funcionario {

	private int funcionario_id;
	private String nome;
	private int cpf;
	private String cargo;
	private float salario;
	
	public int getFuncionario_id() {
		return funcionario_id;
	}
	public void setFuncionario_id(int funcionario_id) {
		this.funcionario_id = funcionario_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
}
