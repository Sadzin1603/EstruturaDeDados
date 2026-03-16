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
    public void ordenarLista() throws Exception {

        ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();

        lista.append(8);
        lista.append(4);
        lista.append(7);
        lista.append(1);
        lista.append(0);
        lista.append(3);
        lista.append(5);
        lista.append(2);

        int total = lista.total();

        for(int i = 0; i < total - 1; i++){
            for(int j = 0; j < total - 1 - i; j++){

                No<Integer> atual = lista.get(j);
                No<Integer> proximo = lista.get(j + 1);

                if(atual.getValor() > proximo.getValor()){

                    int temp = atual.getValor();
                    atual.setValor(proximo.getValor());
                    proximo.setValor(temp);

                }
            }
        }

        System.out.println(lista);
    }
    public void inserirOrdenado(ListaEncadeadaSimples<Integer> lista, int valor) throws Exception{

        if(lista.total() == 0){
            lista.append(valor);
            return;
        }

        for(int i = 0; i < lista.total(); i++){

            if(valor < lista.get(i).getValor()){
                lista.insert(i, valor);
                return;
            }
        }

        lista.append(valor);
    }
    public int[] toArray(ListaEncadeadaSimples<Integer> lista) throws Exception{

        int tamanho = lista.total();

        int[] array = new int[tamanho];

        for(int i = 0; i < tamanho; i++){
            array[i] = lista.get(i).getValor();
        }

        return array;
    }
}