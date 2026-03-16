package controller;

public class Controlador{
	public Controlador(){
		super();
	}
	
	public int potencia(int base,int expoente){
		if(expoente == 0){
			return 1;
		}
		return base*potencia(base,--expoente);
	}
}