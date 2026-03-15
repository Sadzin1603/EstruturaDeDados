package controller;

import model.Pilha;

public class Controller{
    public Controller(){
        super();
    }

    public String teste(){
        Pilha pilha = new Pilha();

        pilha.push(1);
        pilha.push(2);
        pilha.pop();
        pilha.push(3);
        

        return pilha.toString();
    }
}