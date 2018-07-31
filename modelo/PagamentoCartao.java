package modelo;

public class PagamentoCartao extends Pagamento{
	private double totalConta;
	private String cartao;
	private int quantidadeParcelas;
	
	public void calcularPagamento(double totalConta) {
		this.totalConta = totalConta;
	}

}
