package view;

import javax.swing.*;
import controller.Controlador;

public class View {
    public static void main(String[] args){
        try{
            Controlador c = new Controlador();
            
            
            String nome = "kauan";
            System.out.println(c.cadastra(nome));
            nome = "karla";
            System.out.println(c.cadastra(nome));
            nome = "rennan";
            System.out.println(c.cadastra(nome));
            nome = "rayssa";
            System.out.println(c.cadastra(nome));
                
            

            
        }catch( Exception e ){
            e.printStackTrace();
        }
    }
}