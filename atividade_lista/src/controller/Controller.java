package controller;

import model.ListaDupla;

public class Controller {
	private ListaDupla lista = new ListaDupla();
	
	public void addPessoa(String nome) {
		
		lista.add(nome,nome.substring(0,1));
		System.out.println(lista.toString());
		
	}
}
