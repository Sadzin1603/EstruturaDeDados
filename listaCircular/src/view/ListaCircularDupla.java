package view;

import controller.ListaCircularDuplaController;

public class ListaCircularDupla {
    public static void main(String[] args) {
        try {
            ListaCircularDuplaController obj = new ListaCircularDuplaController();
            System.out.println(obj.teste());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}