package controller;

import model.estrutura.ListaCircularDupla;
import model.estrutura.No;

public class ListaCircularDuplaController{
    public ListaCircularDuplaController(){
        super();
    }

    public String teste() throws Exception{
        ListaCircularDupla lista = new ListaCircularDupla();
		
		lista.append(3);
		lista.append(4);
		lista.append(5);
		
		lista.remove(lista.getLast().getProximo());

        return lista.toString();
    }
}