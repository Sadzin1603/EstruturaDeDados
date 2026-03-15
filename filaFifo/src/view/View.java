package view;

import controller.Controlador;

public class View {
	public void main(String[] args) {
		try {
			Controlador c = new Controlador();
			
			System.out.println(c.teste());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
