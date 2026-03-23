package controller;

import model.ListaCircular;
import model.Protocolo;

public class Controlador {
	private ListaCircular lista = new ListaCircular();
	
	public void add(Protocolo elemento) {
		lista.append(elemento);
	}
	
	public void remover() {
		lista.remover();
	}
	
	public String show() {
		return lista.toString();
	}
}
