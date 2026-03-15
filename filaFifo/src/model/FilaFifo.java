package model;

import java.lang.Exception;
import model.No;

public class FilaFifo<T>{
	private No<T> inicio;
	
	//enqueue: adiciona um elemento no final da fifo
	//dequeue: retira o primeiro elemento da fifo
	//last: retorna o ultimo elemento
	
	
	public void enqueue(T elemento) {
		No<T> novo = new No<T>(elemento);
		if(this.inicio==null) {
			this.inicio = novo;
		}else {
			this.last().setProximo(novo);
		}
	}
	
	public No<T> dequeue(){
		if(this.inicio==null){
			return null;
		}
		No<T> primeiro = this.inicio;
		this.inicio = primeiro.getProximo();
		return primeiro;
		
	}
	
	public No<T> last() throws IllegalArgumentException{
		if(this.inicio==null) {
			throw new IllegalArgumentException("Não tem nada na fila");
		}
		No<T> buffer = this.inicio;
		
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
		No<T> buffer = this.inicio;
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