package model;

import model.ListaSimples;
import model.ListaSimples.No;

public class ListaDupla {
	class No{
		private ListaSimples lista;
		private String letra;
		private No proximo;
		private No anterior;
		
		public ListaSimples getValor() {
			return lista;
		}
		public void setValor(ListaSimples lista) {
			this.lista = lista;
		}
		public String getLetra() {
			return letra;
		}
		public void setLetra(String letra) {
			this.letra = letra;
		}
		public No getProximo() {
			return proximo;
		}
		public void setProximo(No proximo) {
			this.proximo = proximo;
		}
		public No getAnterior() {
			return anterior;
		}
		public void setAnterior(No anterior) {
			this.anterior = anterior;
		}
	}
	
	private No inicio;
	
	//ADD, vai receber o nome e a primeira letra, tem q ver se ja tem um nó com essa letra 
	///e se tiver adicionar o nome nela, se não criar um nó com a letra e adicionar o nome depois
	
	public void add(String nome, String letra){

	    if(inicio == null){
	        No novo = new No();
	        novo.setLetra(letra);
	        novo.setValor(new ListaSimples());
	        novo.getValor().append(nome);
	        this.inicio = novo;
	        return;
	    }

	    No atual = this.inicio;

	    while(atual != null){

	        // letra já existe
	        if(atual.getLetra().equalsIgnoreCase(letra)){
	            atual.getValor().append(nome);
	            return;
	        }
	        // inserir antes
	        if(letra.compareToIgnoreCase(atual.letra) < 0){
	            No novo = new No();
	            novo.setLetra(letra);
	            novo.setValor(new ListaSimples());
	            novo.getValor().append(nome);

	            novo.setProximo(atual);
	            novo.setAnterior(atual.getAnterior());

	            if(atual.getAnterior() != null){
	                atual.getAnterior().setProximo(novo);
	            }else{
	                this.inicio = novo;
	            }

	            atual.setAnterior(novo);
	            return;
	        }

	        if(atual.getProximo() == null){
	            break;
	        }

	        atual = atual.getProximo();
	    }

	    // inserir no final
	    No novo = new No();
	    novo.setLetra(letra);
	    novo.setValor(new ListaSimples());
	    novo.getValor().append(nome);

	    atual.setProximo(novo);
	    novo.setAnterior(atual);
	}
	
	//o GET vai receber um nome e a letra, ve se tem o no da letra e ver se tem o nome no no
	public Boolean get(String nome,String letra) {
		if(verificaNos(letra)) {
			No buffer = getLast(letra);
			if(buffer.getValor().temPessoa(nome)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public void remove(String nome,String letra) {
		if(verificaNos(letra)) {
			No buffer = getLast(letra);
			if(buffer.getValor().temPessoa(nome)) {

				buffer.getValor().remove(buffer.getValor().getLast(nome));;
			}
			if(buffer.getValor().getInicio()==null) {//remover esse  nó
				if(buffer == this.inicio) {//quero remover o primeiro
					
					if(buffer.getProximo()!=null) {//se tem alguem na frente
						No proximo = buffer.getProximo();
						proximo.setAnterior(null);
						inicio = proximo;
					}
					
				}
				else {//quero remover
					if(buffer.getProximo()!=null) {//tem proximo
						No proximo = buffer.getProximo();
						proximo.setAnterior(buffer.getAnterior());
						No anterior = buffer.getAnterior();
						anterior.setProximo(buffer.getProximo());
					}else {
						No anterior = buffer.getAnterior();
						anterior.setProximo(null);
					}
					
				}
				buffer.setValor(null);
				buffer.setAnterior(null);
				buffer.setProximo(null);
			}
		}
		
	}
	
	public Boolean verificaNos(String letra) {
		No buffer = this.inicio;
		
		while(buffer != null) {
		    if(buffer.letra.equals(letra)) {
		        return true;
		    }
		    buffer = buffer.getProximo();
		}
		return false;
		
			
	}
	
	public No getLast(String letra) {
		//preguiça de tratar erro
		//if(inicio == null) {
		//	return 0;
		//}
		if(letra.isEmpty()) {
			No buffer = inicio;
			while(buffer.proximo!=null) {
				buffer = buffer.getProximo();
			}
			return buffer;
		}else {

			No buffer = inicio;
			if(buffer.letra.equals(letra)) {
				return buffer;
			}
			while(buffer.proximo!=null) {

				buffer = buffer.getProximo();
				if(buffer.letra.equals(letra)) {
					return buffer;
				}
			}
			return buffer;
		}
	}
	
	@Override
	public String toString() {
		String text ="[";
		No buffer = this.inicio;
		text+=buffer.getValor().toString();
		while(buffer.getProximo()!=null) {
			buffer = buffer.getProximo();
			text+=", "+buffer.getValor().toString();
		}
		text+="]";
		return text;
	}
}
