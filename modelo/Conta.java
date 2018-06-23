package modelo;

import java.util.ArrayList;


public class Conta {
	private int numero;
	private String dtfechamento;
	private double total;
	private Mesa mesa;
	private ArrayList<Produto> produtos;
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getDtfechamento() {
		return dtfechamento;
	}
	
	public void setDtfechamento(String dtfechamento) {
		this.dtfechamento = dtfechamento;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Mesa getMesa() {
		return mesa;
	}
	
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", dtfechamento=" + dtfechamento + ", total=" + total + ", mesa=" + mesa
				+ ", produtos=" + produtos + "]";
	}

	public Conta(int numero, String dtfechamento, double total, Mesa mesa) {
		super();
		this.numero = numero;
		this.dtfechamento = dtfechamento;
		this.total = total;
		this.mesa = mesa;
		this.produtos = null;
	}
	
	public void addProduto(Produto p){
		this.produtos.add(p);
	}
	
	public void removeProduto(Produto p) {
		this.produtos.remove(p);
	}
	
	public Produto buscarProduto(String nome) {
		for(Produto p:produtos) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}
}
