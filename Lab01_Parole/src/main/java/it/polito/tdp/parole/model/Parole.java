package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	List<String> listaParole;
	
	public Parole() {
//		this.listaParole = new ArrayList<String>();
		this.listaParole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		this.listaParole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(listaParole);
		return this.listaParole;
	}
	
	public void reset() {
		this.listaParole.clear();
	}
	
	public void cancella(String p) {
		this.listaParole.remove(p);
	}

}
