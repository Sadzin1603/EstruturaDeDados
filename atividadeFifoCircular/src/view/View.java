package view;

import controller.Controlador;
import model.Protocolo;

public class View {

	public static void main(String[] args) {
		Controlador c = new Controlador();
		
		c.add(new Protocolo("http","GET"));
		c.add(new Protocolo("http","POST"));
		c.add(new Protocolo("pop","NUM SEI"));
		c.add(new Protocolo("smtp","SEI LA"));
		c.add(new Protocolo("pop","NUM SEI 2"));
		c.add(new Protocolo("http","DELETE"));
		c.add(new Protocolo("http","PATCH"));
		
		c.remover();
		c.remover();
		c.remover();
		c.remover();
		c.remover();
		c.remover();
		c.remover();
		
		System.out.println(c.show());
	}

}
