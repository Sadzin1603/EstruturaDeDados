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
	
	public void add(String nome,String letra) {
		
		if(this.inicio == null) { //não tem nenhuma letra
			No novo = new No();
			novo.letra = letra;
			ListaSimples lista = new ListaSimples();
			novo.lista= lista;
			novo.lista.append(nome);
			this.inicio = novo;
		}else {//se ja tem alguma letra
			if(verificaNos(letra)) {//se ja tem um no com essa letra
				
				No existente = getLast(letra);
				
				existente.lista.append(nome);
			}else {
				
				No novo = new No();
				No ultimo = getLast("");
				novo.letra = letra;
				ListaSimples lista = new ListaSimples();
				novo.lista= lista;
				novo.lista.append(nome);
				novo.setAnterior(ultimo);
				ultimo.setProximo(novo);
			}
		}
	}
	
	public Boolean get(String nome) {
		
		return false;
	}
	
	public Boolean verificaNos(String letra) {
		No buffer = this.inicio;
		
		Boolean res = false;
		if(buffer.letra.equals(letra)) {
			res = true;	
		}
		while(buffer.getProximo()!= null){
			buffer = buffer.getProximo();
			if(buffer.letra.equals(letra)) {
				res = true;	
			}
			
		}
		return res;
		
			
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
