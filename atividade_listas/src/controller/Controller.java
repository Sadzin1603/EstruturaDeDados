package controller;

import model.ListaDupla;

public class Controller {
	private ListaDupla lista = new ListaDupla();
	
	public String addPessoa(String nome) {
		
		lista.add(nome,nome.substring(0,1));
		return lista.toString();
		
	}
	
	public String procura(String nome) {
		if(lista.get(nome,nome.substring(0,1))) {;
			return "Nome existente";
		}else {
			return "Nome n�o existente na lista";
		}
	}
	
	public String remove(String nome) {
		lista.remove(nome,nome.substring(0,1));
		return lista.toString();
	}
}
