package br.com.farmacia;

public class Fornecedor {
	
	private int fornecedor_id;
	private String nome_fornecedor;
	private float preco;
	private String prod_fornecido;
	private int quantidade;
	
	public int getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(int fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public String getNome_fornecedor() {
		return nome_fornecedor;
	}
	public void setNome_fornecedor(String nome_fornecedor) {
		this.nome_fornecedor = nome_fornecedor;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getProd_fornecido() {
		return prod_fornecido;
	}
	public void setProd_fornecido(String prod_fornecido) {
		this.prod_fornecido = prod_fornecido;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
