package fachada;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {


	// coloquei métodos da fachada, seguindo documentação
	// deve buscar por algo que for digitado
	public static ArrayList<Produto> listarProdutos(Produto nome){
		return ArrayList<Produto>;
		}
	//ao digitar enter, deve listar todos os produtos
	public static ArrayList<Produto> listarProdutos(ActionEvent e){
		return ArrayList<Produto>;
		}

	public static ArrayList<Garcom> listarGarcons(){
		return ArrayList<Garcom>;
		}

	public static ArrayList<Mesa> listarMesass(){
		return ArrayList<Mesa>;
		}

	public static ArrayList<Conta> listarContas(){
		return ArrayList<Conta>;
		}

	public static void criarMesas(int n){
		
		
	}

	public static Produto cadastrarProduto(String nome, double preco) {
		return Produto;
	}

	public static Garcom cadastrarGarcom(String apelido, int[] mesainicial, int[] mesafinal){
		return Garcom;
	}

	public static Conta criarConta(int idmesa){
		return idmesa;
	}

	public static Conta consultarConta(int idmesa){
		return Conta;
	}

	public static Produto solicitarProduto(int idmesa, String nomeproduto){
		return Produto;
	}

	public static void cancelarConta(int idmesa){
	
	}

	public static void transferirConta(int idmesaorigem, int idmesadestino){
	
	}

	public static void fecharConta(int idmesa){
	
	}

	public static double calcularGorjeta(String apelido){
		return;
	}

	public static void addGarcom(Garcom g) {
		
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
