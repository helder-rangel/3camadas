package modelo;

import java.util.ArrayList;


public class Garcom {
	private static String apelido;
	private ArrayList<Mesa> mesas  = new ArrayList<Mesa>();
	
	public static String getApelido() {
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
	}
	
	@Override
	public String toString() {
		String texto = "Garcom [apelido=" + apelido + ", mesas=";
		if (mesas.isEmpty()) {
			texto += " vazia";
		}else {
			for(Mesa m: mesas) 
				texto += " " + m.getId()+",";
		} 	
		texto += "]";
		return texto;		
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
