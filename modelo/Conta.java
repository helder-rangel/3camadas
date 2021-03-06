package modelo;

import java.util.ArrayList;


public class Conta {
	private int numero;
	private String dtfechamento;
	private double total;
	private Mesa mesa;
	private ArrayList<Produto> produtos  = new ArrayList<Produto>();
	
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
		String texto = "Conta [numero=" + numero + ", dtfechamento=" + dtfechamento + ", total=" + total + ", mesa=" + mesa.getId(); 
		if(produtos.isEmpty()) {
			texto += " sem produtos.";
		}else {
			for(Produto m: produtos) 
				texto += " " + m.getNome()+",";
		}
		return texto;
				
	}

	public Conta(int numero, Mesa mesa) {
		super();
		this.numero = numero;
		this.dtfechamento = null;
		this.total = 0;
		this.mesa = mesa;
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
