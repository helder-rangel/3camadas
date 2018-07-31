package modelo;

public abstract class Pagamento {
	private double valorPago;
	
	public abstract void calcularPagamento(double totalConta);
	
	public double calcularGorjeta(double gorjeta) {
		
		return gorjeta;
	}

	public boolean isPago() {
		// TODO Auto-generated method stub
		return false;
	}

}
