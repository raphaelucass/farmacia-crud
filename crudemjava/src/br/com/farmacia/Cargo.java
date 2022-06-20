package br.com.farmacia;

public class Cargo {

	private int cargo_id;
	private String gerente;
	private String farmaceutico;
	private String balconista;
	
	public int getCargo_id() {
		return cargo_id;
	}
	public void setCargo_id(int cargo_id) {
		this.cargo_id = cargo_id;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getFarmaceutico() {
		return farmaceutico;
	}
	public void setFarmaceutico(String farmaceutico) {
		this.farmaceutico = farmaceutico;
	}
	public String getBalconista() {
		return balconista;
	}
	public void setBalconista(String balconista) {
		this.balconista = balconista;
	}
}
