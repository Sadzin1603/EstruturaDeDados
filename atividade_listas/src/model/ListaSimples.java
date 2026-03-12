package model;

import model.ListaDupla.No;

public class ListaSimples<T> {
	class No{
		private T valor;
		private No proximo;
		
		public No(T valor) {
			this.valor = valor;
		}

		public T getValor() {
			return valor;
		}

		public void setValor(T valor) {
			this.valor = valor;
		}

		public No getProximo() {
			return proximo;
		}

		public void setProximo(No proximo) {
			this.proximo = proximo;
		}
		
	}
	private No inicio;
	
	public No  getInicio() {
		return this.inicio;
	}
	
	public void append(T elemento) {//Coleguinha, vamos agora organizar os nomes quando entram e depois as letras
		
		No novo = new No(elemento);
		String nome = elemento.toString();
		
		if(this.inicio==null || nome.compareTo(this.inicio.getValor().toString()) < 0) {
			
			novo.setProximo(this.inicio);
			this.inicio = novo;
			return;
		}
		
		
		No atual = this.inicio;
		
		while(atual.getProximo() !=null && atual.getProximo().getValor().toString().compareTo(nome) < 0) {
			System.out.println("ai ai ai ");
			atual = atual.getProximo();
		}
		
		
		novo.setProximo(atual.getProximo());
		atual.setProximo(novo);
		
	}
	public No getLast(String nome) {
		//preguiça de tratar erro
		//if(inicio == null) {
		//	return 0;
		//}
		if(nome.isEmpty()) {
			No buffer = inicio;
			while(buffer.proximo!=null) {
				buffer = buffer.getProximo();
			}
			return buffer;
		}else {
			
			No buffer = inicio;
			if(buffer.getValor().equals(nome)) {
				return buffer;
			}
			while(buffer.proximo!=null) {

				buffer = buffer.getProximo();
				if(buffer.getValor().equals(nome)) {
					return buffer;
				}
			}
			return buffer;
		}
	}
	
	public No getAnterior(T nome) {
		
		No buffer = this.inicio;
		
		while(buffer!=null) {
			if(buffer.getProximo().getValor().equals(nome)) {
				
				return buffer;
			}
			buffer = buffer.getProximo();
		}
		
		return buffer;
	}
	
	public Boolean temPessoa(String nome) {
		if(inicio==null) {
			return false;
		}
		No buffer = inicio;
		while(buffer != null) {
		    if(buffer.getValor().equals(nome)) {
		        return true;
		    }
		    buffer = buffer.getProximo();
		}
		
		return false;
	}
	
	public void remove(No elemento) {
		if(elemento == this.inicio) {//quero remover o primeiro
			if(elemento.getProximo()!=null) {//se tem mais coisa
				this.inicio = elemento.getProximo();
			}else {
				this.inicio = null;
			}
			
		}else {
			No anterior = getAnterior(elemento.getValor());
			anterior.setProximo(elemento.getProximo());
		}
		elemento.setProximo(null);
		elemento.setValor(null);
	}
	
	@Override
	public String toString(){
		if(this.inicio == null){
			return "[]";
		}
		String text = "[";
		No buffer = this.inicio;
		text+= buffer.getValor();
		while(buffer.getProximo()!=null){
			buffer = buffer.getProximo();
			text+= ", " + buffer.getValor();
		}
		text+="]";

		return text;
	}
	
	
}
