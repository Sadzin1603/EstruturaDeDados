package controller;

import model.Arvore;
import model.ListaSimples;

public class Controlador {
	Arvore tree = new Arvore();
	public String teste() {
		String res="";
		ListaSimples lista;
		int[] values = {30, 25, 40, 23, 28, 35, 45, 22, 24, 27, 29, 31, 36, 41, 46};

        for (int v : values) {
            tree.add(v);
        }
        tree.remove(40);
        
        lista = tree.ordem();
        res+="Ordem:     "+lista.toString()+"\n";
        
        lista = tree.preordem();
        res+="Pre-Ordem: "+lista.toString()+"\n";
        
        lista = tree.posordem();
        res+="Pos-Ordem: "+lista.toString();
        return res;
	}
}
