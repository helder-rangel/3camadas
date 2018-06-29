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
	private static Restaurante repositorio = new Restaurante();
	private static int idmesas = 0;
	private static int idcontas = 0;
	private static Double gorjeta = 0.0;
		
	public Fachada() {
		super();
	}
	
	public static Produto buscarProduto (String nome) throws Exception{
		Produto produto = repositorio.buscarProduto(nome);
		if(produto==null) {
			throw new Exception("Produto não encontrado.");
		}
		return produto;
	}
	
	public static ArrayList<Produto> listarProdutos() throws Exception{
		ArrayList<Produto> produtos = repositorio.getProdutos();
		if(produtos==null) {
			throw new Exception("Não existem produtos cadastrados no restaurante.");
		}
		return produtos;
	}

	public static ArrayList<Garcom> listarGarcons() throws Exception{
		ArrayList<Garcom> garcons = repositorio.getGarcons();
		if(garcons==null) {
			throw new Exception("Não existem garçons cadastrados no restaurante.");
		}
		return garcons;
	}

	public static ArrayList<Mesa> listarMesas() throws Exception{
		ArrayList<Mesa> mesas = repositorio.getMesas();
		if(mesas==null) {
			throw new Exception("Não existem mesas cadastrados no restaurante.");
		}
		return mesas;
	}

	public static ArrayList<Conta> listarContas() throws Exception{
		ArrayList<Conta> contas = repositorio.getContas();
		if(contas==null) {
			throw new Exception("Não existem mesas cadastrados no restaurante.");
		}
		return contas;
	}

	public static void criarMesas(int quantidade){
		while(quantidade >= 0) {
			Mesa m = new Mesa(Fachada.idmesas);
			repositorio.addMesa(m);
			Fachada.idmesas++;
			quantidade--;
		}
	}

	public static Produto cadastrarProduto(String nome, double preco) {
		Produto produtoCriado = new Produto(nome, preco);
		repositorio.addProduto(produtoCriado);
		return produtoCriado;
	}

	public static Garcom cadastrarGarcom(String apelido, int mesainicial, int mesafinal){
		Garcom garcom = new Garcom(apelido);
		repositorio.mesasGarcom(mesainicial, mesafinal, garcom);
		repositorio.addGarcom(garcom);
		return garcom;
	}

	public static Conta criarConta(int idmesa) throws Exception{
		Mesa mesa = repositorio.buscarMesa(idmesa);
		
		if(mesa==null) {
			throw new Exception("Mesa não existe.");
		}
		
		if(mesa.isOcupada()==true) {
			throw new Exception("Última conta da mesa ainda não foi fechada.");
		}
		
		Conta novaConta = new Conta(Fachada.idcontas,mesa);
		Fachada.idcontas++;
		repositorio.addConta(novaConta);
		mesa.addConta(novaConta);//Adiciona a referencia de conta na mesa
		mesa.setOcupada(true);
		return novaConta;
	}

	public static Conta consultarConta(int idmesa) throws Exception{
		Mesa mesa = repositorio.buscarMesa(idmesa);
		if(mesa==null) {
			throw new Exception("Mesa não existe.");
		}
		Conta conta = mesa.contaDaMesa(); //Criei esse método
		return conta;
	}

	public static Produto solicitarProduto(int idmesa, String nomeproduto) throws Exception{
		Produto produto = repositorio.buscarProduto(nomeproduto);
		if(produto==null) {
			throw new Exception("Produto não existe.");
		}
		Conta conta = Fachada.consultarConta(idmesa);
		conta.addProduto(produto);
		double total = conta.getTotal();
		total += produto.getPreco();
		conta.setTotal(total);
		return produto;
	}

	public static void cancelarConta(int idmesa){
		Mesa mesa = repositorio.buscarMesa(idmesa);
		Conta conta = mesa.contaDaMesa();
		mesa.removeConta(conta);
		mesa.setOcupada(false);
		repositorio.removeConta(conta);
	}

	public static void transferirConta(int idmesaorigem, int idmesadestino){
		//Busca as mesas
		Mesa mesaOrigem = repositorio.buscarMesa(idmesaorigem);
		Mesa mesaDestino = repositorio.buscarMesa(idmesadestino);
		//Busca a conta
		Conta conta = mesaOrigem.contaDaMesa();
		//Seta a nova mesa na conta
		conta.setMesa(mesaDestino);
		//Adiciona a conta na nova mesa
		mesaDestino.addConta(conta);
		//Remova a conta da antiga mesa
		mesaOrigem.removeConta(conta);
		//Altera os status das duas mesas
		mesaDestino.setOcupada(true);
		mesaOrigem.setOcupada(false);
	}

	public static void fecharConta(int idmesa) throws Exception{
		Mesa mesa = repositorio.buscarMesa(idmesa);
		Conta conta = mesa.contaDaMesa();
		if(conta.getDtfechamento()!=null) {
			throw new Exception("Conta já fechada.");
		}
		String data = repositorio.dataHoraAtual();
		conta.setDtfechamento(data);
		mesa.setOcupada(false);
	}

	public static double calcularGorjeta(String apelido) throws Exception{
		Fachada.gorjeta = 0.0;
		Garcom garcom = repositorio.buscarGarcom(apelido);
		if(garcom==null) {
			throw new Exception("Garçom não existe.");
		}
		ArrayList<Mesa> mesas = garcom.getMesas();
		Date dataHoraAtual = new Date();
		String dataDeHoje = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		for(Mesa m : mesas) {
			for(Conta c : m.getContas()) {
				if(c.getDtfechamento().equals(dataDeHoje)) {
					Fachada.gorjeta = Fachada.gorjeta + (c.getTotal() * 0.10); 
				}
			}
		}
		return Fachada.gorjeta;
	}
	
	public static Produto addProduto(String nome, double preco) {
		Produto produto = new Produto(nome, preco);
		repositorio.addProduto(produto);
		return produto;
	}
	
}
