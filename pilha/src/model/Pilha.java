package model;

import model.No;

public class Pilha<T>{
    private No<T> ultimo;
    
    public void push(T elemento){//colocar o elemento em cima da pilha
        No<T> novo = new No<T>(elemento);       
        if(this.ultimo!=null){//ja tem coiso na pilha
            novo.setAnterior(this.ultimo);
        }
        this.ultimo = novo;
    }

    public No<T> pop(){//tirar o ultimo elemento da pilha
        if(this.ultimo==null){
            return null;
        }
        No<T> buffer = this.ultimo;
        this.ultimo = this.ultimo.getAnterior();
        return buffer;
    }

    @Override
    public String toString(){
        if(this.ultimo == null){
            return "[]";
        }
        No<T> buffer = this.ultimo;
        StringBuilder builder = new StringBuilder("[");
        builder.append(buffer.toString());
        while(buffer.getAnterior()!=null){
            builder.append(", ");
            buffer = buffer.getAnterior();
            builder.append(buffer.toString());

        }
        builder.append("]");

        return builder.toString();
    }
}