package model;

import model.ListaFifo.No;

public class ListaCircular<T> {
	public class No{
		private ListaFifo lista;
		private No proximo;
		private No anterior;
		
		public No(ListaFifo lista) {
			this.lista = lista;
		}
		
		public ListaFifo getLista() {
			return this.lista;
		}
		public void setLista(ListaFifo lista) {
			this.lista = lista;
		}
		
		public No getProximo() {
			return this.proximo;
		}
		public void setProximo(No proximo) {
			this.proximo=proximo;
		}
		
		public No getAnterior() {
			return anterior;
		}

		public void setAnterior(No anterior) {
			this.anterior = anterior;
		}

		@Override
		public String toString() {
			return this.lista.toString();
		}
	}
	private No ultimo;
	private No ponteiro;
	
	public void append(Protocolo elemento) {
		if(this.ultimo==null) {//não tem nada
			
			ListaFifo lista = new ListaFifo();
			lista.enqueue(elemento);
			
			No novo = new No(lista);
			novo.setProximo(novo);
			novo.setAnterior(novo);
			this.ultimo = novo;
		}else {//ja tem coiso,tenho q ver se ja tem o tipo de protoclo
			
			if(temTipo(elemento.getType())!=null) {//tem o tipo, adiciono na fila
				
				No buffer = temTipo(elemento.getType());
				buffer.getLista().enqueue(elemento);
			}else {//crio a lista e o elemento e tenho q adicionalo
				
				ListaFifo lista = new ListaFifo();
				lista.enqueue(elemento);
				
				No novo = new No(lista);
				novo.setProximo(this.ultimo.getProximo());
				novo.setAnterior(this.ultimo);
				this.ultimo.setProximo(novo);
				
				
				this.ultimo = novo;
				
				
			}
		}
	}
	
	public No temTipo(String tipo) {
		if(this.ultimo==null) {
			return null;
		}
		No buffer = this.ultimo;
		if(buffer.getLista().getType().equals(tipo)) {
			return buffer;
		}
		while(buffer.getProximo()!=this.ultimo) {
			
			buffer = buffer.getProximo();
			
			if(buffer.getLista().getType().equals(tipo)) {
				return buffer;
			}
		}
		
		return null;
	}
	
	public void remover() {
		if(this.ponteiro==null) {
			this.ponteiro = this.ultimo; 
		}
		//tenho q tirar da fila, mas só se não tiver vazio
		
		
		
		
		this.ponteiro.getLista().dequeue();
		
		this.ponteiro = this.ponteiro.getProximo();
		No buffer = this.ponteiro;
		while(this.ponteiro.toString().equals("[]")) {
			this.ponteiro = this.ponteiro.getProximo();
			if(this.ponteiro==buffer) {
				break;
			}
		}
		
	}
	
	@Override
	public String toString() {
		String text = "[";
		No buffer = this.ultimo;
		text+=buffer.getLista();
		while(buffer.getProximo()!=this.ultimo) {
			text+=", ";
			buffer = buffer.getProximo();
			text+=buffer.getLista();
		}
		text+="]";
		return text;
	}
	
}
