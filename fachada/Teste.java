package fachada;

import java.util.ArrayList;

import fachada.Fachada;
import modelo.Produto;

public class Teste {

	
	
	
	public static void main(String[] args) throws Exception {
		Fachada.addProduto("funciona", 1.0);
		ArrayList<Produto> produtos = Fachada.listarProdutos();
		System.out.println(produtos.toString());

	}

}
