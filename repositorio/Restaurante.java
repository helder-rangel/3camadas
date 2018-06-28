package repositorio;


import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	public void addConta(Conta c) {
		this.contas.add(c);
	}
	
	public void removeConta(Conta c) {
		this.contas.remove(c);
	}
	
	public Conta buscarConta(int id) {
		for(Conta c:contas) {
			if(c.getNumero()==id) {
				return c;
			}
		}
		return null;
	}
	
	public void addMesa(Mesa m) {
		this.mesas.add(m);
	}
	
	public void removeMesa(Mesa m) {
		this.mesas.remove(m);
	}
	
	public Mesa buscarMesa(int id) {
		for(Mesa m:mesas) {
			if(m.getId()==id) {
				return m;
			}
		}
		return null;
	}
	
	public void addGarcom(Garcom m) {
		this.garcons.add(m);
	}
	
	public void removeGarcom(Garcom m) {
		this.garcons.remove(m);
	}
	
	public Garcom buscarGarcom(String apelido) {
		for(Garcom m:garcons) {
			if(m.getApelido().equals(apelido)) {
				return m;
			}
		}
		return null;
	}
	
	public String dataHoraAtual() {
		 Date dataHoraAtual = new Date();
		 String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
	     //String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	     //String dataHora = data+" - "+hora;
	     String dataHora = data;
	     return dataHora;
	}
	
}
