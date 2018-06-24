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
	
	
	//Você vai fazer tudo com base no repositório
	
	//ao digitar enter, deve listar todos os produtos
	//ESSE APERTAR ENTER É LÁ NA TELA AQUI SÓ VAI RETORNAR DADOS
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

	
	
	//Todos esses abaixo vc já tem esses métodos prontos no repositório então pq refazer? vou refazer um deles como deve ficar e tu atualiza o resto.
	
	public void addGarcom(String apelido) {
		//Você não vai receber o garçom aqui, vc vai receber o apelido, lembra a view só vai te mandar dados(String, int.. Toda a regra deve ser feita aqui!)
		//Como esse método já pronto, então eu recebo o int e mando para o repositório criar o garçom.
		//Se vc quiser uma confirmação para a tela e tals, tu pode colocar para boolean e retornar um true se tudo deu certo
		Garcom g = new Garcom(apelido);
		repositorio.addGarcom(g);
	}

	public void removeGarcom(String apelido){
		//Usando a mesma lógica do anterior logo:
		Garcom g = repositorio.buscarGarcom(apelido);
		//vou buscar a referencia do garçom e depois excluir
		//Esse G tu vai ter o mesmo conteudo do garcom lá no repositorio, logo se vc excluir ou alterar reflete lá também
		repositorio.removeGarcom(g);
	}	

	public Garcom buscarGarcom(String apelido) {
		Garcom g = repositorio.buscarGarcom(apelido);
		return g;
	}

	
	//O mesmo vale para os próximos só seguindo a lógica de cada 1
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
