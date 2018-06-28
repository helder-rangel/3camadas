package fachada;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {
	private Restaurante repositorio = new Restaurante();
	private static int idmesas = 0;
	private static int idcontas = 0;
	private ArrayList<Mesa> mesas = null;
	private Double gorjeta = 0.0;
		
	public Fachada() {
		super();
	}
	
	public Produto buscarProduto (String nome) throws Exception{
		Produto p = repositorio.buscarProduto(nome);
		if(p==null) {
			throw new Exception("Produto n�o encontrado.");
		}
		return p;
	}
	
	public ArrayList<Produto> listarProdutos() throws Exception{
		ArrayList<Produto> produtos = repositorio.getProdutos();
		if(produtos==null) {
			throw new Exception("N�o existem produtos cadastrados no restaurante.");
		}
		return produtos;
	}

	public ArrayList<Garcom> listarGarcons() throws Exception{
		ArrayList<Garcom> garcons = repositorio.getGarcons();
		if(garcons==null) {
			throw new Exception("N�o existem gar�ons cadastrados no restaurante.");
		}
		return garcons;
	}

	public ArrayList<Mesa> listarMesas() throws Exception{
		ArrayList<Mesa> mesas = repositorio.getMesas();
		if(mesas==null) {
			throw new Exception("N�o existem mesas cadastrados no restaurante.");
		}
		return mesas;
	}

	public ArrayList<Conta> listarContas() throws Exception{
		ArrayList<Conta> contas = repositorio.getContas();
		if(contas==null) {
			throw new Exception("N�o existem mesas cadastrados no restaurante.");
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
		this.mesas = null; //Toda vez que chamar o m�todo ele limpa
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
			throw new Exception("Mesa n�o existe.");
		}
		
		if(m.isOcupada()==true) {
			throw new Exception("�ltima conta da mesa ainda n�o foi fechada.");
		}
		
		Conta c = new Conta(Fachada.idcontas,m);
		Fachada.idcontas++;
		repositorio.addConta(c);
		m.addConta(c);//Adiciona a referencia de conta na mesa
		m.setOcupada(true);
		return c;
	}

	public Conta consultarConta(int idmesa) throws Exception{
		Mesa m = repositorio.buscarMesa(idmesa);
		if(m==null) {
			throw new Exception("Mesa n�o existe.");
		}
		Conta c = m.contaDaMesa(); //Criei esse m�todo
		return c;
	}

	public Produto solicitarProduto(int idmesa, String nomeproduto) throws Exception{
		Produto p = repositorio.buscarProduto(nomeproduto);
		if(p==null) {
			throw new Exception("Produto n�o existe.");
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
		mesaOrigem.setOcupada(false);
		mesaDestino.setOcupada(true);
	}

	public void fecharConta(int idmesa) throws Exception{
		Mesa m = repositorio.buscarMesa(idmesa);
		Conta c = m.contaDaMesa();
		if(c.getDtfechamento()!=null) {
			throw new Exception("Conta j� fechada.");
		}
		String data = repositorio.dataHoraAtual();
		c.setDtfechamento(data);
		m.setOcupada(false);
	}

	public double calcularGorjeta(String apelido, double total) throws Exception{
		this.gorjeta = 0.0;
		Garcom garcom = repositorio.buscarGarcom(apelido);
		if(garcom==null) {
			throw new Exception("Gar�om n�o existe.");
		}
		ArrayList<Mesa> mesas = garcom.getMesas();
		Date dataHoraAtual = new Date();
		String dataDeHoje = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		for(Mesa m : mesas) {
			for(Conta c : m.getContas()) {
				if(c.getDtfechamento().equals(dataDeHoje)) {
					this.gorjeta = this.gorjeta + (c.getTotal() * 0.10); 
				}
			}
		}
		return this.gorjeta;
	}
	
	//=====================
	public Produto addProduto(String nome, double preco) {
		Produto p = new Produto(nome, preco);
		repositorio.addProduto(p);
		return p;
	}
}
