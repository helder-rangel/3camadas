package fachada;
		 
		import java.util.ArrayList;
		 
		import fachada.Fachada;
		import modelo.Produto;
		import modelo.Garcom;
		import modelo.Mesa;
		import modelo.Conta;
		 
		public class TesteRapido {
		     
		    public static void main (String[] args) {  
		        parte1();
		        parte2();
		        System.out.println("fim do teste");
		    }
		 
		    public static void parte1(){
		        try {   
		            Produto p;
		            p = Fachada.addProduto("feijoada", 25.0);
		            p = Fachada.addProduto("bode guisado", 20.0);
		            p = Fachada.addProduto("galhinhada", 15.0);
		            p = Fachada.addProduto("cerveja", 6.0);
		            p = Fachada.addProduto("refrigerante", 5.0);
		            p = Fachada.addProduto("agua", 2.0);
		            ArrayList<Produto> produtos = Fachada.listarProdutos();
		            System.out.println("produtos cadastrados:");
		            System.out.println(produtos);
		 
		            Fachada.criarMesas(20);     // 20 mesas
		            ArrayList<Mesa> mesas = Fachada.listarMesas();
		            System.out.println("mesas criadas:");
		            System.out.println(mesas);
		 
		            Garcom g;
		            g = Fachada.cadastrarGarcom("baixinho", 1,5);
		            g = Fachada.cadastrarGarcom("esperto", 6,10);
		            g = Fachada.cadastrarGarcom("zezinho", 10,15);
		            g = Fachada.cadastrarGarcom("zezinho", 16,20);
		            ArrayList<Garcom> garcons = Fachada.listarGarcons();
		            System.out.println("garcons cadastrados:");
		            System.out.println(garcons);
		 
		        }catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		    }
		 
		 
		    public static void parte2() {
		        try {
		            Fachada.criarConta(1);  //mesa 1
		            Fachada.solcitarProduto(1, "galinhada");
		            Fachada.solcitarProduto(1, "cerveja");
		            Fachada.solcitarProduto(1, "refrigerante");
		            System.out.println("conta da mesa 1: \n"+ Fachada.consultarConta(1)); 
		            Fachada.solcitarProduto(1, "cerveja");
		            Fachada.solcitarProduto(1, "cerveja");
		            Fachada.fecharConta(1);
		            System.out.println("conta da mesa 1: \n"+ Fachada.consultarConta(1)); 
		 
		 
		            Fachada.criarConta(5);  //mesa 5
		            Fachada.solcitarProduto(5, "feijoada");
		            Fachada.solcitarProduto(5, "cerveja");
		            Fachada.fecharConta(5);
		            System.out.println("conta da mesa 5: \n"+ Fachada.consultarConta(5)); 
		 
		 
		            double gorjeta = Fachada.calcularGorjeta("baixinho");
		            System.out.println("gorjeta do baixinho="+gorjeta);
		 
		            ArrayList<Conta> contas = Fachada.listarContas();
		            System.out.println("contas existentes:");
		            System.out.println(contas);
		             
		        }catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		    }
		     
		     
		 
		 
		}

	}


}
