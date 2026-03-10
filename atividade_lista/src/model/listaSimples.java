package model;

import java.lang.Exception;

public class listaSimples<T>{ // Essa porrinha daq vai ser uma lista que guarda os nomes de uma letra inicial
    class No{
        private T valor;
        private No proximo;
        
        public No(T valor){
            this.valor = valor;
        }

        public T getValor(){
            return this.valor;
        }
        public No getProximo(){
            return this.proximo;
        }
        public void setProximo(No no){
            this.proximo = no;
        }
        @Override
        public String toString(){
            return valor.toString();
        }

    }
    private No inicio;

    public listaSimples(T valor){
        append(elemento);
    }

    public void append(T elemento){
        System.out.println(elemento.toString());
        No novo = new No(elemento);
        if(this.inicio == null){ //n tem nada na porra da lista
            this.inicio = novo;
        }else{
            getLast().setProximo(novo);
        }

        

    }
    
    public No getLast() throws IllegalArgumentException{
        if(this.inicio == null){ // não tem nada
            throw new IllegalArgumentException("Não tem nada na lista");
        }

        No buffer = this.inicio;
    

        while(buffer.getProximo()!=null){
            buffer = buffer.getProximo();
        }

        return buffer;
    }

    @Override
    public String toString(){
        if(this.inicio == null){
            return "Não tem nothing";
        }
        if(this.inicio.getProximo() == null){
            return this.inicio.toString();
        }
        No buffer = this.inicio;
        String text ="["+inicio.toString();
        do{
            text+=", ";
            buffer = buffer.getProximo();
            text+=buffer.toString();
            
        }while(buffer.getProximo()!=null);
        text+="]";
        return text;
    }
    
}