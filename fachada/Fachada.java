package fachada;

import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {

	public static void addGarcom(Garcom g) {
		Garcom.garcons.add(g);
	}
	
	public static void removeGarcom(Garcom g){
		garcons.remove(g);
	}	
	
	public static Garcom buscarGarcom(String apelido) {
		for(Garcom c:garcons) {
			if(c.getApelido().equals(apelido)) {
				return c;
			}
		}
		return null;
	}
	
	public static void addConta(Conta c) {
		contas.add(c);
	}
	
	public static void removeConta(Conta c) {
		contas.remove(c);
	}
	
	public static Conta buscarConta(int id) {
		for(Conta c:contas) {
			if(c.getNumero()==id) {
				return c;
			}
		}
		return null;
	}
	
	public static void addMesa(Mesa m) {
		mesas.add(m);
	}
	
	public static void removeMesa(Mesa m) {
		mesas.remove(m);
	}
	
	public static Mesa buscarMesa(int id) {
		for(Mesa m:mesas) {
			if(m.getId()==id) {
				return m;
			}
		}
		return null;
	}
	
	public static Produto addProduto(String no, double pre){
		return addProduto(no,pre);
	}
	
	public static void removeProduto(Produto p) {
		produtos.remove(p);
	}
	
	public static Produto buscarProduto(String nome) {
		for(Produto p:produtos) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}


}
