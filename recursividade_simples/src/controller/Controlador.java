package controller;

public class Controlador{
	public Controlador(){
		super();
	}
	
	public void imprimir(int numero){
		if(numero>= 10) return;
		System.out.println("Numero: " + numero);
		imprimir(++numero);
	}
}