package view;

import controller.ListaEncadeadaSimplesController;

public class ListaEncadeadaSimplesView{
    public static void main(String[] args){
        try{
            ListaEncadeadaSimplesController obj = new ListaEncadeadaSimplesController();
            System.out.println(obj.teste());
        }catch( Exception e ){
            e.printStackTrace();
        }
    }
}