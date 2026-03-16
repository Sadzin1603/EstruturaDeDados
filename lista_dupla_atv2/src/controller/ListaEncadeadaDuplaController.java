package controller;

import model.estrutura.ListaEncadeadaDupla;
import model.estrutura.No;

public class ListaEncadeadaDuplaController{
	public ListaEncadeadaDupla lista = new ListaEncadeadaDupla();
    public ListaEncadeadaDuplaController() {
		
        super();
    }

    public String teste() throws Exception{
        

        lista.appendOrdenado("Clara");
        lista.appendOrdenado("Ana");
        lista.appendOrdenado("Zenaider");
		lista.appendOrdenado("Wellington");

        

        return lista.toString();
    }
	public String reverse(){
		return lista.reversetoString();
	}
}