package model.estrutura;

import java.lang.Exception;
import model.estrutura.No;

public class ListaEncadeadaDupla<T>{
    private No<T> inicio = null;
    private No<T> fim = null;
    //append        Adiciona o elemento no final;
    //get           Retorna um no dado um index;
    //index         Retorna um indice de um elemento;
    //insert        Insere um elemento em uma determinada posicao
    //last          Retorna o ultimo olemento;
    //prepend       Adiociona o elemento no começo;
    //remove        Remove um elemento dado o index;
    //total         Retorna o total de elementos;

    public void appendOrdenado(T elemento){
		No<T> novo = new No<>(elemento);

		if(this.inicio == null){ // lista vazia
			this.inicio = novo;
			this.fim = novo;
			return;
		}

		No<T> atual = this.inicio;

		while(atual != null && atual.getValor().toString().compareToIgnoreCase(elemento.toString()) < 0){
			atual = atual.getProximo();
		}

		if(atual == this.inicio){ // inserir no começo
			novo.setProximo(inicio);
			inicio.setAnterior(novo);
			inicio = novo;

		}else if(atual == null){ // inserir no final
			fim.setProximo(novo);
			novo.setAnterior(fim);
			fim = novo;

		}else{ // inserir no meio
			No<T> anterior = atual.getAnterior();

			anterior.setProximo(novo);
			novo.setAnterior(anterior);

			novo.setProximo(atual);
			atual.setAnterior(novo);
		}
	}

    public No<T> get(int index) throws IllegalArgumentException {
        int i = 0;
        if (this.inicio == null)
            throw new IllegalArgumentException("Nao existe item na lista");

        No<T> buffer = this.inicio;

        for (i = 0; i < index; i++) {
            if (buffer.getProximo() == null)
                buffer = buffer.getProximo();
        }

        if (i < index)
            throw new IllegalArgumentException("O indice informado nao existe");

        return buffer;
    }

    public int index (T elemento) throws IllegalArgumentException {
        if(this.inicio == null) //não tem nada
            throw new IllegalArgumentException ("Não existe item na lista");
        
        int index=0;
        if(this.inicio.getValor()==elemento)//se for o primeiro ja retorna
            return index;
        
        No<T> buffer = this.inicio;
        do{
            if(buffer.getValor() == elemento){
                return index;
            }
            buffer = buffer.getProximo();
            index++;
        }while(buffer!=null);
        throw new IllegalArgumentException ("Item nao encontrado.");
    } 

    public void insert(int index,T elemento) throws IllegalArgumentException {
        if(index==0){
            No<T> novo = new No<>(elemento);
            if(this.inicio==null){
                this.inicio = null;
                this.fim = null;
            }else{
                No<T> ex_inicio = this.inicio;
                novo.setProximo(ex_inicio);
                this.inicio = novo;
                ex_inicio.setAnterior(novo);
            }
        }else{
            this.insert(this.get(--index),elemento);
        }
    }

    public void insert(No<T> item,T elemento) throws IllegalArgumentException {
        No<T> novo = new No<>(elemento);
        No<T> proximo = item.getProximo();
        item.setProximo(novo);
        novo.setProximo(proximo);
        proximo.setAnterior(novo);
        novo.setAnterior(item);
    }

    public No<T> last() throws IllegalArgumentException {
        if(this.inicio == null)
            throw new IllegalArgumentException ("Não existe item na lista");
        No<T> buffer = this.inicio;
        while(buffer.getProximo()!=null){
            buffer = buffer.getProximo();
        }
        return buffer;
    }

    public void prepend(T elemento){
        No<T> buffer = new No<>(elemento);
        if(this.fim == null){
            this.fim = buffer;
            this.inicio = buffer;
        }else{
            No<T> ex_primeiro = this.inicio;
            this.inicio = buffer;
            buffer.setProximo(ex_primeiro);
            ex_primeiro.setAnterior(buffer);
        }
    }

    public void remove(int index){
        if(index==0){
            this.inicio.setValor(null);
            this.inicio.setAnterior(null);
            if(this.inicio.getProximo() == null){
                this.inicio = null;
                this.fim = null;
            }else{
                No<T> buffer = this.inicio.getProximo();
                No<T> anterior = this.inicio.getAnterior();
                
                this.inicio.setProximo(null);
                this.inicio = buffer;   
            }
            return;
        }
        No<T> anterior = this.get(index-1);
        No<T> item = anterior.getProximo();
        No<T> proximo = item.getProximo();
        anterior.setProximo(proximo);
        proximo.setAnterior( anterior );
        item.setAnterior(null);
        item.setProximo(null);
        item.setValor(null);
    }

    public int total(){
        if(this.inicio==null)
            return 0;
        No<T> buffer = this.inicio;
        int total_elementos =0;
        do{
            total_elementos++;
            buffer = buffer.getProximo();
        }while(buffer.getProximo()!=null);
        return total_elementos;
    }

    @Override
    public String toString(){
        if(this.inicio == null){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.inicio;
        builder.append(buffer.getValor());
        while(buffer.getProximo()!=null){
            builder.append(",");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
    }
	
	public String reversetoString(){
		if(this.fim == null){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.fim;
        builder.append(buffer.getValor());
        while(buffer.getAnterior()!=null){
            builder.append(",");
            buffer = buffer.getAnterior();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
	}


}