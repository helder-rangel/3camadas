package repositorio;


import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;

import java.util.ArrayList;

public class Restaurante {
	
	private ArrayList<Conta> contas;
	private ArrayList<Mesa> mesas;
	private ArrayList<Garcom> garcons;
	private ArrayList<Produto> produtos;
	
	public ArrayList<Conta> getContas() {
		return contas;
	}
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}
	public ArrayList<Garcom> getGarcons() {
		return garcons;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}
	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	public void setGarcons(ArrayList<Garcom> garcons) {
		this.garcons = garcons;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
}
