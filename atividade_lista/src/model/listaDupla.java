package model;

import model.listaSimples;

public class listaDupla<T>  {
    class No{
        private T valor;
        private No proximo;
        private No anterior;

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
        public No getAnterior(){
            return this.anterior;
        }
        public void setAnterior(No no){
            this.anterior = no;
        }
        @Override
        public String toString(){
            return valor.toString();
        }
    }
    private No inicio;

    public void append(T elemento){
        No novo = new No(elemento);
        if(this.inicio == null){
            this.inicio = novo;
        }else{
            No antigo = getLast();
            antigo.setProximo(novo);
            novo.setAnterior(antigo);
        }
    }

    public No getLast()throws IllegalArgumentException{
        if(this.inicio==null){
            throw new IllegalArgumentException("não tem ultimo, não tem nada");
        }
        No buffer = this.inicio;
        while(buffer.getProximo()!=null){
            buffer=buffer.getProximo();
        }
        return buffer;
    }

    @Override
    public String toString(){
        if(this.inicio == null){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder("[");
        No buffer = this.inicio;
        builder.append(buffer.getValor());
        while(buffer.getProximo()!=null){
            builder.append(",");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
    }

}