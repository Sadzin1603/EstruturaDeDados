package view;

import controller.Controlador;

public class View{
	public static void main(String[] args){
		try{
			Controlador c = new Controlador("terra.com.br");
			c.links("https://www.terra.com.br/");
		}catch(Exception e){
				System.out.println("Falha ao carreegar");
				e.printStackTrace();
		}	
		
	}
}