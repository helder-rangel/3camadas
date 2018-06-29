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
	
	public Produto buscarProduto (String nome) throws Exception{
		Produto p = repositorio.buscarProduto(nome);
		if(p==null) {
			throw new Exception("Produto não encontrado.");
		}
		return p;
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
		Produto p = new Produto(nome, preco);
		repositorio.addProduto(p);
		return p;
	}

	public static Garcom cadastrarGarcom(String apelido, int mesainicial, int mesafinal){
		Garcom g = new Garcom(apelido);
		repositorio.mesasGarcom(mesainicial, mesafinal, g);
		repositorio.addGarcom(g);
		return g;
	}

	public static Conta criarConta(int idmesa) throws Exception{
		Mesa m = repositorio.buscarMesa(idmesa);
		
		if(m==null) {
			throw new Exception("Mesa não existe.");
		}
		
		if(m.isOcupada()==true) {
			throw new Exception("Última conta da mesa ainda não foi fechada.");
		}
		
		Conta c = new Conta(Fachada.idcontas,m);
		Fachada.idcontas++;
		repositorio.addConta(c);
		m.addConta(c);//Adiciona a referencia de conta na mesa
		m.setOcupada(true);
		return c;
	}

	public static Conta consultarConta(int idmesa) throws Exception{
		Mesa m = repositorio.buscarMesa(idmesa);
		if(m==null) {
			throw new Exception("Mesa não existe.");
		}
		Conta c = m.contaDaMesa(); //Criei esse método
		return c;
	}

	public static Produto solicitarProduto(int idmesa, String nomeproduto) throws Exception{
		Produto p = repositorio.buscarProduto(nomeproduto);
		if(p==null) {
			throw new Exception("Produto não existe.");
		}
		Conta c = Fachada.consultarConta(idmesa);
		c.addProduto(p);
		double total = c.getTotal();
		total += p.getPreco();
		c.setTotal(total);
		return p;
	}

	public static void cancelarConta(int idmesa){
		Mesa m = repositorio.buscarMesa(idmesa);
		Conta c = m.contaDaMesa();
		m.removeConta(c);
		repositorio.removeConta(c);
	}

	public static void transferirConta(int idmesaorigem, int idmesadestino){
		Mesa mesaOrigem = repositorio.buscarMesa(idmesaorigem);
		Mesa mesaDestino = repositorio.buscarMesa(idmesadestino);
		
		Conta c = mesaOrigem.contaDaMesa();
		c.setMesa(mesaDestino);
		mesaDestino.addConta(c);
		mesaOrigem.removeConta(c);
		mesaDestino.setOcupada(true);
		mesaOrigem.setOcupada(false);
	}

	public static void fecharConta(int idmesa) throws Exception{
		Mesa m = repositorio.buscarMesa(idmesa);
		Conta c = m.contaDaMesa();
		if(c.getDtfechamento()!=null) {
			throw new Exception("Conta já fechada.");
		}
		String data = repositorio.dataHoraAtual();
		c.setDtfechamento(data);
		m.setOcupada(false);
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
		Produto p = new Produto(nome, preco);
		repositorio.addProduto(p);
		return p;
	}
	
}
