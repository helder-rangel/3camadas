package fachada;


	import java.util.ArrayList;

	import modelo.Conta;
	import modelo.Garcom;
	import modelo.Mesa;
	import modelo.Produto;
	import modelo.Pagamento;
	import modelo.PagamentoDinheiro;
	import repositorio.Restaurante;

	public class Ariana {
		private static Restaurante repositorio = new Restaurante();
		private static int idmesas = 0;
		private static int idcontas = 0;
		private static double media;
		
		public static ArrayList<Produto> litarProduto() throws Exception {
			ArrayList<Produto> produtos = repositorio.getProdutos();
			if(produtos==null) {
				throw new Exception ("N�o h� produtos cadastrados");
			}
			return produtos;
		}
		
		public static ArrayList<Garcom> listarGarcons() throws Exception {
			ArrayList<Garcom> garcons = repositorio.getGarcons();
			if(garcons==null) {
				throw new Exception ("N�o h� gar�ons cadastrados");
			}
			return garcons;
			
		}
		
		public static ArrayList<Mesa> listarMesas() throws Exception {
			ArrayList<Mesa> mesas = repositorio.getMesas();
			if(mesas==null) {
				throw new Exception ("N�o h� mesas cadastradas");
			}
			return mesas;
		}
		
		public static ArrayList<Conta> listarContas() throws Exception {
			ArrayList<Conta> contas = repositorio.getContas();
			if(contas==null) {
				throw new Exception("N�o h� contas cadastradas");
			}
			return contas;
		}
		
		public static void criarMesa(int quantidade) {
			while(quantidade>= 0) {
				Mesa mesa = new Mesa(idmesas);
				repositorio.addMesa(mesa);
				idmesas++;
				quantidade--;
			}
		}
		
		public static Produto cadastrarProduto(String nome, double preco) {
			Produto produto = new Produto(nome, preco);
			repositorio.addProduto(produto);
			return produto;
		}
		
		public static Garcom cadastrarGarcom(String apelido, int mesainicial, int mesafinal) {
			Garcom garcom = new Garcom(apelido);
			repositorio.mesasGarcom(mesainicial, mesafinal, garcom);
			repositorio.addGarcom(garcom);
			return garcom;
		}
		
		public static Conta criarConta(int idmesa) throws Exception {
			Mesa mesa = repositorio.buscarMesa(idmesa);
			
			if(mesa==null) {
				throw new Exception("Mesa n�o exisite");
			}
			
			if(mesa.isOcupada()) {
				throw new Exception("�ltima conta da mesa ainda n�o foi fechada");
			}
			
			Conta novaConta = new Conta(idcontas, mesa);
			idcontas++;
			repositorio.addConta(novaConta);
			mesa.addConta(novaConta);
			mesa.setOcupada(true);
			
			return novaConta;
		}
		
		public static Conta consultarConta(int idmesa) throws Exception {
			Mesa mesa = repositorio.buscarMesa(idmesa);
			if(mesa==null) {
				throw new Exception("Mesa n�o existe");
			}	
			
			Conta conta = mesa.contaDaMesa();
			return conta;
		}
		
		public static Produto solicitarProduto(int idmesa, String nomeproduto) throws Exception {
			Produto produto = repositorio.buscarProduto(nomeproduto);
			if(produto==null) {
				throw new Exception("Produto n�o existe");
			}
			Conta conta = Fachada.consultarConta(idmesa);
			conta.addProduto(produto);
			double total = conta.getTotal();
			total += produto.getPreco();
			conta.setTotal(total);
			return produto;
		}
		
		// excluir a conta da mesa e do restaurante
		public static void cancelarConta(int idmesa) throws Exception {
			Mesa mesa = repositorio.buscarMesa(idmesa);
			Conta conta = mesa.contaDaMesa();
			mesa.removeConta(conta);
			mesa.setOcupada(false);
			repositorio.removeConta(conta);
		}
		
		public static void transferirConta(int idmesaorigem, int idmesadestino) throws Exception{
			// buscar mesas
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
			mesaOrigem.setOcupada(false);
			mesaDestino.setOcupada(true);
		}
		
		public static void fecharConta(int idmesa) throws Exception {
			Mesa mesa = repositorio.buscarMesa(idmesa);
			Conta conta = mesa.contaDaMesa();
			if(conta.getDtfechamento()!=null) {
				throw new Exception ("Conta est� fechada");
			}
			
			String data = repositorio.dataHoraAtual();
			conta.setDtfechamento(data);
			mesa.setOcupada(false);
		}
		
		public static double calcularGorjeta(String apelido) throws Exception {
			
			return idcontas;
			
		}
		
		public static Pagamento pagarConta(int idmesa, Pagamento p, int percentualDesconto) throws Exception {
			PagamentoDinheiro pag = (PagamentoDinheiro) p;
			if(p.isPago()) throw new Exception("Essa conta est� paga!");
			
			Mesa mesa = Restaurante.buscarMesa(idmesa);
			if(mesa == null) throw new Exception("Mesa inv�lida");
			if(percentualDesconto < 0 || percentualDesconto > 5) throw new Exception("Percentual inv�lido para desconto");
			if(mesa.contaDaMesa() == null) throw new Exception("N�o existe conta nessa mesa");
			if(mesa.contaDaMesa().getDtfechamento()== null)throw new Exception("Tentaiva inv�lida: conta deve estar fechada para ser paga");
			
			return pag;
		}
		
		public static void excluirGarcom(String apelido) throws Exception {
			if(!Garcom.getApelido().equals(apelido)) throw new Exception("N�o h� este gar�om no restaurante");
			if(Garcom.getApelido().equals(apelido)) {
				apelido = null;
			}
			
		}
			
		public static double calcularPercentualMedio( String apelido) throws Exception {
			
			return media;
		}

	}

