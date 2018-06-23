package modelo;

import java.util.ArrayList;


public class Garcom {
	private String apelido;
	private ArrayList<Mesa> mesas;
	
	public String getApelido() {
		return apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}
	
	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public Garcom(String apelido) {
		super();
		this.apelido = apelido;
		this.mesas = null;
	}
	
	@Override
	public String toString() {
		return "Garcom [apelido=" + apelido + ", mesas=" + mesas + "]";
	}
	
	public void addMesa(Mesa m) {
		this.mesas.add(m);
	}
	
	public void removeMesa(Mesa m) {
		this.mesas.remove(m);
	}
	
	public Mesa buscarMesa(int id) {
		for(Mesa m:mesas) {
			if(m.getId()==id) {
				return m;
			}
		}
		return null;
	}
}
