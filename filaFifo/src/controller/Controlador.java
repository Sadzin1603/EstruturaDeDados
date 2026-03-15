package controller;

import java.io.*;
import model.FilaFifo;

public class Controlador {
	
	public String teste() throws IOException{
		FilaFifo fila = new FilaFifo();
		
		fila.enqueue( 1 );
		fila.enqueue( 2 );
		fila.enqueue( 3 );
		fila.dequeue();
		
		
		return fila.toString();
	}
}
