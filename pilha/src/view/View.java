package view;

import controller.Controller;

public class View{
    public void main(String[] args){
        try{
            Controller c = new Controller();
            System.out.println(c.teste());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}