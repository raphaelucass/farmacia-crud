
package br.com.farmacia;

import java.util.Date;

public class Medicamento {
    private int id;
    private String nome_laboratorio;
    private float preco;
    private Date dt_vencimento;
    private String nome_medicamento;
    private int qtd_estoque;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome_laboratorio(String string) {
        this.nome_laboratorio = string;
    }

    public void setPreco(float d) {
        this.preco = d;
    }

    public void setDt_vencimento(Date dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public void setNome_medicamento(String string) {
        this.nome_medicamento = string;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public int getId() {
        return id;
    }

    public String getNome_laboratorio() {
        return nome_laboratorio;
    }

    public float getPreco() {
        return preco;
    }

    public Date getDt_vencimento() {
        return dt_vencimento;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

}