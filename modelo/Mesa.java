package modelo;

import java.util.ArrayList;


public class Mesa {
	private int id;
	private boolean ocupada;
	private Garcom garcom;
	private ArrayList<Conta> contas;
	
	public Mesa(int id, boolean ocupada, Garcom garcom) {
		super();
		this.id = id;
		this.ocupada = ocupada;
		this.garcom = garcom;
		this.contas = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", ocupada=" + ocupada + ", garcom=" + garcom + ", contas=" + contas + "]";
	}
	
	public void addConta(Conta c) {
		this.contas.add(c);
	}
	
	public void removeConta(Conta c) {
		this.contas.remove(c);
	}
	
	public Conta buscarConta(int id) {
		for(Conta c:contas) {
			if(c.getNumero()==id) {
				return c;
			}
		}
		return null;
	}
}
