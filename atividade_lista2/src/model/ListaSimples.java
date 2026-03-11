package model;

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
	
	public void append(T elemento) {
		No novo = new No(elemento);
		if(this.inicio==null) {
			inicio = novo;
		}else {
			No ultimo = getLast();
			ultimo.setProximo(novo);
			
		}
	}
	public No getLast() {
		//preguiça de tratar erro
		//if(inicio == null) {
		//	return 0;
		//}
		No buffer = inicio;
		while(buffer.proximo!=null) {
			buffer = buffer.getProximo();
		}
		return buffer;
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
