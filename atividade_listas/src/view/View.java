package view;

import controller.Controller;

public class View {

	public static void main(String[] args) {
		Controller c = new Controller();
		
		System.out.println(c.addPessoa("Kauan"));
		System.out.println(c.addPessoa("Kaleb"));
		
		System.out.println(c.addPessoa("Pedro"));
		System.out.println(c.addPessoa("Paulo"));
		System.out.println(c.addPessoa("Karlos"));
		
		System.out.println(c.addPessoa("Ana"));
		System.out.println(c.addPessoa("Arnaldo"));
		System.out.println(c.addPessoa("Alexia"));
		
		System.out.println(c.procura("Kauan"));
		System.out.println(c.procura("Pedro"));
		System.out.println(c.procura("Hugo"));
		
		System.out.println(c.remove("Karlos"));
		
		System.out.println(c.remove("Pedro"));
		System.out.println(c.remove("Paulo"));
		
		
	}

}
