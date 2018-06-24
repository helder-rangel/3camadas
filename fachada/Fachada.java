package fachada;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {
	Restaurante repositorio;
		
	public Fachada(Restaurante repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	
	//Voc� vai fazer tudo com base no reposit�rio
	
	//ao digitar enter, deve listar todos os produtos
	//ESSE APERTAR ENTER � L� NA TELA AQUI S� VAI RETORNAR DADOS
	public ArrayList<Produto> listarProdutos(ActionEvent e){
		return repositorio.getProdutos();
	}

	public ArrayList<Garcom> listarGarcons(){
		return repositorio.getGarcons();
	}

	public ArrayList<Mesa> listarMesass(){
		return repositorio.getMesas();
	}

	public ArrayList<Conta> listarContas(){
		return repositorio.getContas();
	}

	public void criarMesas(int n){
		
		
	}

	public Produto cadastrarProduto(String nome, double preco) {
		return Produto;
	}

	public Garcom cadastrarGarcom(String apelido, int[] mesainicial, int[] mesafinal){
		return Garcom;
	}

	public Conta criarConta(int idmesa){
		return idmesa;
	}

	public Conta consultarConta(int idmesa){
		return Conta;
	}

	public Produto solicitarProduto(int idmesa, String nomeproduto){
		return Produto;
	}

	public void cancelarConta(int idmesa){
	
	}

	public void transferirConta(int idmesaorigem, int idmesadestino){
	
	}

	public void fecharConta(int idmesa){
	
	}

	public double calcularGorjeta(String apelido){
		return;
	}

	
	
	//Todos esses abaixo vc j� tem esses m�todos prontos no reposit�rio ent�o pq refazer? vou refazer um deles como deve ficar e tu atualiza o resto.
	
	public void addGarcom(String apelido) {
		//Voc� n�o vai receber o gar�om aqui, vc vai receber o apelido, lembra a view s� vai te mandar dados(String, int.. Toda a regra deve ser feita aqui!)
		//Como esse m�todo j� pronto, ent�o eu recebo o int e mando para o reposit�rio criar o gar�om.
		//Se vc quiser uma confirma��o para a tela e tals, tu pode colocar para boolean e retornar um true se tudo deu certo
		Garcom g = new Garcom(apelido);
		repositorio.addGarcom(g);
	}

	public void removeGarcom(String apelido){
		//Usando a mesma l�gica do anterior logo:
		Garcom g = repositorio.buscarGarcom(apelido);
		//vou buscar a referencia do gar�om e depois excluir
		//Esse G tu vai ter o mesmo conteudo do garcom l� no repositorio, logo se vc excluir ou alterar reflete l� tamb�m
		repositorio.removeGarcom(g);
	}	

	public Garcom buscarGarcom(String apelido) {
		Garcom g = repositorio.buscarGarcom(apelido);
		return g;
	}

	
	//O mesmo vale para os pr�ximos s� seguindo a l�gica de cada 1
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
