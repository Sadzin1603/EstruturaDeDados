package controller;

public class Controlador{
	public Controlador(){
		super();
	}
	
	public int calcular(int numero){
		if(numero <= 1){
			return 1;
		}
		return numero*calcular(--numero);
	}
}