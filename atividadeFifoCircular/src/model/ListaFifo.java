package model;

import model.Protocolo;

public class ListaFifo<T> {
	public class No{
		private Protocolo valor;
		private No proximo;
		
		public No(Protocolo valor) {
			this.valor = valor;
		}
		
		public Protocolo getValor() {
			return this.valor;
		}
		public void setValor(Protocolo valor) {
			this.valor = valor;
		}
		
		public No getProximo() {
			return this.proximo;
		}
		public void setProximo(No proximo) {
			this.proximo=proximo;
		}
		@Override
		public String toString() {
			return this.valor.toString();
		}
	}
	private No inicio;
	private String type;
	
	public String getInicio() {
		return this.inicio.getValor().toString();
	}
	public String getType() {
		return this.type;
	}
	
	public void enqueue(Protocolo elemento) {
		No novo = new No(elemento);
		if(this.inicio==null) {
			this.inicio = novo;
			this.type = novo.getValor().getType();
		}else {
			this.last().setProximo(novo);
		}
	}
	
	public No dequeue(){
		if(this.inicio==null){
			return null;
		}
		No primeiro = this.inicio;
		this.inicio = primeiro.getProximo();
		return primeiro;
		
	}
	
	public No last() throws IllegalArgumentException{
		if(this.inicio==null) {
			throw new IllegalArgumentException("Não tem nada na fila");
		}
		No buffer = this.inicio;
		
		while(buffer.getProximo()!=null) {
			buffer = buffer.getProximo();
		}
		
		return buffer;
	}
	
	@Override
	public String toString() {
		if(this.inicio==null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No buffer = this.inicio;
		builder.append(buffer.toString());
		while(buffer.getProximo()!=null) {
			builder.append(", ");
			buffer = buffer.getProximo();
			builder.append(buffer.toString());
		}
		
		builder.append("]");
		
		return builder.toString();
	}

	
}
