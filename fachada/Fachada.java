package fachada;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {
	private Restaurante repositorio = new Restaurante();
	private static int idmesas = 0;
	private static int idcontas = 0;
	private ArrayList<Mesa> mesas;
		
	public Fachada() {
		super();
	}
	
	public Produto buscarProduto (String nome) throws Exception{
		Produto p = repositorio.buscarProduto(nome);
		if(p==null) {
			throw new Exception("Produto não encontrado.");
		}
		return p;
	}
	
	public ArrayList<Produto> listarProdutos() throws Exception{
		ArrayList<Produto> produtos = repositorio.getProdutos();
		if(produtos==null) {
			throw new Exception("Não existem produtos cadastrados no restaurante.");
		}
		return produtos;
	}

	public ArrayList<Garcom> listarGarcons() throws Exception{
		ArrayList<Garcom> garcons = repositorio.getGarcons();
		if(garcons==null) {
			throw new Exception("Não existem garçons cadastrados no restaurante.");
		}
		return garcons;
	}

	public ArrayList<Mesa> listarMesas() throws Exception{
		ArrayList<Mesa> mesas = repositorio.getMesas();
		if(mesas==null) {
			throw new Exception("Não existem mesas cadastrados no restaurante.");
		}
		return mesas;
	}

	public ArrayList<Conta> listarContas() throws Exception{
		ArrayList<Conta> contas = repositorio.getContas();
		if(contas==null) {
			throw new Exception("Não existem mesas cadastrados no restaurante.");
		}
		return contas;
	}

	public void criarMesas(int quantidade){
		while(quantidade == 0) {
			Mesa m = new Mesa(Fachada.idmesas);
			repositorio.addMesa(m);
			Fachada.idmesas++;
			quantidade--;
		}
	}

	public Produto cadastrarProduto(String nome, double preco) {
		Produto p = new Produto(nome, preco);
		repositorio.addProduto(p);
		return p;
	}

	public Garcom cadastrarGarcom(String apelido, int mesainicial, int mesafinal){
		this.mesas = null; //Toda vez que chamar o método ele limpa
		while(mesainicial <= mesafinal) {
			Mesa e = repositorio.buscarMesa(mesainicial);
			mesas.add(e);
			mesainicial++;
		}
		Garcom g = new Garcom(apelido, mesas);
		return g;
	}

	public Conta criarConta(int idmesa) throws Exception{
		Mesa m = repositorio.buscarMesa(idmesa);
		
		if(m==null) {
			throw new Exception("Mesa não existe.");
		}
		
		Conta c = new Conta(Fachada.idcontas,m);
		Fachada.idcontas++;
		repositorio.addConta(c);
		m.addConta(c);//Adiciona a referencia de conta na mesa
		return c;
	}

	public Conta consultarConta(int idmesa) throws Exception{
		Mesa m = repositorio.buscarMesa(idmesa);
		if(m==null) {
			throw new Exception("Mesa não existe.");
		}
		Conta c = m.contaDaMesa(); //Criei esse método
		return c;
	}

	public Produto solicitarProduto(int idmesa, String nomeproduto) throws Exception{
		Produto p = repositorio.buscarProduto(nomeproduto);
		if(p==null) {
			throw new Exception("Produto não existe.");
		}
		Conta c = this.consultarConta(idmesa);
		c.addProduto(p);
		return p;
	}

	public void cancelarConta(int idmesa){
		Mesa m = repositorio.buscarMesa(idmesa);
		Conta c = m.contaDaMesa();
		m.removeConta(c);
		repositorio.removeConta(c);
	}

	public void transferirConta(int idmesaorigem, int idmesadestino){
		Mesa mesaOrigem = repositorio.buscarMesa(idmesaorigem);
		Mesa mesaDestino = repositorio.buscarMesa(idmesadestino);
		Conta contOrigem = mesaOrigem.contaDaMesa();
		Conta contDestino = mesaDestino.contaDaMesa();
		ArrayList<Produto> produtos = contOrigem.getProdutos();
		
		//Apagar a conta
		mesaOrigem.removeConta(contOrigem);
		repositorio.removeConta(contOrigem);
		
		//transferir produtos
		for (Produto p:produtos) {
			contDestino.addProduto(p);
		}
	}

	public void fecharConta(int idmesa){
		Mesa m = repositorio.buscarMesa(idmesa);
		Conta c = m.contaDaMesa();
		String data = repositorio.dataHoraAtual();
		c.setDtfechamento(data);
	}

	public double calcularGorjeta(String apelido, double total){
		return ;
	}
}
