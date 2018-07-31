package modelo;

public class PagamentoDinheiro extends Pagamento {
	private int percentualDesconto;
	private double totalConta;
	private PagamentoDinheiro tipo; // pra quê fiz isso?

	public void calcularPagamento(double totalConta) {
		this.totalConta = totalConta;
	};


}
