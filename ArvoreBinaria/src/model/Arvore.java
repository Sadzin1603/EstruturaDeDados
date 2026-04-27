package model;

import model.ListaSimples;

public class Arvore<T extends Comparable> {
	class No {
		private T valor;
		private No menor;
		private No maior;
		
		public No(T valor) {
			this.valor = valor;
		}

		public T getValor() {
			return valor;
		}

		public void setValor(T valor) {
			this.valor = valor;
		}

		public No getMenor() {
			return menor;
		}

		public void setMenor(No menor) {
			this.menor = menor;
		}

		public No getMaior() {
			return maior;
		}

		public void setMaior(No maior) {
			this.maior = maior;
		}
		@Override
		public String toString() {
			return this.valor.toString();
		}
		
	}
	private No raiz;
	private int tamanho;
	
	public void add(T valor) {
		No novo = new No(valor);
		tamanho++;
		if(this.raiz == null) {
			this.raiz = novo;
		}else {
			No buffer = this.raiz;
			while(true) {
				if(novo.getValor().compareTo(buffer.getValor()) < 1) {
					if(buffer.getMenor()!=null) {//tem um menor
						buffer = buffer.getMenor();
					}else {
						buffer.setMenor(novo);
						break;
					}
				}else {
					if(buffer.getMaior()!=null) {//tem um menor
						buffer = buffer.getMaior();
					}else {
						buffer.setMaior(novo);
						break;
					}
				}
			}
		}
	}
	
	public ListaSimples ordem() {
		ListaSimples lista = new ListaSimples();
		No atual = this.raiz;
		ordem(atual,lista);
		return lista;
	}
	public ListaSimples preordem() {
		ListaSimples lista = new ListaSimples();
		No atual = this.raiz;
		preordem(atual,lista);
		return lista;
	}
	public ListaSimples posordem() {
		ListaSimples lista = new ListaSimples();
		No atual = this.raiz;
		posordem(atual,lista);
		return lista;
	}
	
	public void ordem(No atual, ListaSimples lista) {
		if(atual != null) {
			ordem(atual.getMenor(),lista);
			lista.append(atual);
			ordem(atual.getMaior(),lista);
		}
	}
	public void preordem(No atual, ListaSimples lista) {
		if(atual != null) {
			lista.append(atual);
			preordem(atual.getMenor(),lista);
			preordem(atual.getMaior(),lista);
		}
	}
	public void posordem(No atual, ListaSimples lista) {
		if(atual != null) {
			posordem(atual.getMenor(),lista);
			posordem(atual.getMaior(),lista);
			lista.append(atual);
			
		}
	}
	public boolean remove(T valor) {
		//Buscar o no na arvore
		No atual = this.raiz;
		No paiAtual = null;
		while(atual!=null) {
			if(atual.getValor().equals(valor)) {
				break;
			}else if(valor.compareTo(atual.getValor())==-1) {//se o valor buscado é menor
				paiAtual = atual;
				atual = atual.getMenor();
			}else {
				paiAtual = atual;
				atual = atual.getMaior();
			}
		}
		//verifica se existe o No
		if(atual == null) {
			return false;
		}
		//ver se tem
		if(atual.getMaior() != null) {
			No substituto = atual.getMaior();
			No paiSubstituto = atual;
			while(substituto.getMenor()!=null) {
				paiSubstituto = substituto;
				substituto = substituto.getMenor();
			}
			substituto.setMenor(atual.getMenor());
			
			if(paiAtual!=null) {//verificar se é a raiz
				if(atual.getValor().compareTo(paiAtual.getValor())==-1) {
					paiAtual.setMenor(substituto);
				}else {
					paiAtual.setMaior(substituto);
				}
			}else {
				//se não tem pai é raiz
				this.raiz = substituto;
				paiSubstituto.setMenor(null);
				this.raiz.setMaior(paiSubstituto);
				this.raiz.setMenor(atual.getMenor());
			}
			if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) {
				paiSubstituto.setMenor(null);
				substituto.setMaior(paiSubstituto);
			}else {
				paiSubstituto.setMaior(null);
			}
		}else if(atual.getMenor() != null) {
			//tem filho só a esquerda
			No substituto = atual.getMenor();
			No paiSubstituto = atual;
			
			while(substituto.getMaior()!=null) {
				paiSubstituto = substituto;
				substituto = substituto.getMaior();
			}
			if(paiAtual != null) {
				if(atual.getValor().compareTo(paiAtual.getValor()) == -1) {//atual < paiAtual
					paiAtual.setMenor(substituto);
				}else {
					paiAtual.setMaior(substituto);
				}
			}else {
				this.raiz = substituto;
			}
			
			if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) {
				paiSubstituto.setMenor(null);
			}
			else {
				paiSubstituto.setMaior(null);
			}
		}else {//Não tem filhos (Castrado)
			if(paiAtual != null) {
				if(atual.getValor().compareTo(paiAtual.getValor()) == -1) {
					paiAtual.setMenor(null);
				}else {
					paiAtual.setMaior(null);
				}
			}else {
				this.raiz = null;
			}
		}
		return true;
	}
}
