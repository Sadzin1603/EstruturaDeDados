package controller;

import model.ListaDupla;

public class Controller {
	private ListaDupla lista = new ListaDupla();
	
	public String addPessoa(String nome) {
		
		lista.add(nome,nome.substring(0,1));
		return lista.toString();
		
	}
	
	public String procura(String nome) {
		if(lista.get(nome)) {;
			return "Nome existente";
		}else {
			return "Nome não existente na lista";
		}
	}
}
