package controller;

import model.listaSimples;
import model.listaDupla;

public class Controlador {
    listaDupla lista = new listaDupla();//lista de nomes

    public String cadastra(String nome) throws Exception{
        
        this.lista.append(nome);

        return this.lista.toString();
    }
}