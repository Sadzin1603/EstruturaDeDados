package controller;

import model.estrutura.ListaEncadeadaSimples;
import model.estrutura.No;
import model.estrutura.Pessoa;

public class ListaEncadeadaSimplesController{
    public ListaEncadeadaSimplesController() {
        super();
    }

    public String teste() throws Exception{
        ListaEncadeadaSimples<Pessoa> lista = new ListaEncadeadaSimples<>();

        lista.append(new Pessoa("Kauan",19));
        lista.append(new Pessoa("Pedro",19));
        lista.append(new Pessoa("Hugo",25));

        //lista.remove(2);
		
		System.out.println(lista.get(0).getValor().getNome());
		System.out.println(lista.get(1).getValor().getNome());
		System.out.println(lista.get(2).getValor().getNome());
		
        Pessoa encontrada = lista.buscarPorNome("Pedro");

        if(encontrada != null){
            System.out.println("Pessoa encontrada: " + encontrada.getNome());
        }else{
            System.out.println("Pessoa não encontrada");
        }

        return lista.toString();
    }
}