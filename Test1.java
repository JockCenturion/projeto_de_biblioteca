import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.io.Console;


public class Test1 {
	public static void main(String[] args)  {
		
		
		/*//Os livros da Biblioteca
		Livro livro1 = new Livro("Java");
		Livro livro2 = new Livro("C++");
		Livro livro3 = new Livro("C#");
		
		
		//Os Periodicos
		Periodico p1 = new Periodico("TCC1");
		Periodico p2 = new Periodico("TCC2");
		
		//Criando três tipos de Usuarios
		Usuario 			externo 	= new Usuario("Marcia");
		UsuarioAluno 		interno 	= new UsuarioAluno("Jock", new Date());
		UsuarioProfessor 	prof		= new UsuarioProfessor("Brodoc"); */
		
		/*
		//Adicionar Livro para externo
		System.out.println(externo.retiraLivro(livro1));
		externo.listaCarga();
		
		System.out.println("\n\n");
		
		System.out.println(interno.retiraLivro(livro2));
		interno.renovaCartao(new Date(2017, 6, 19, 21, 51));	//Date(int year, int month, int date, int hrs, int min) //new Date(2017, 6, 19, 21, 51)
		interno.listaCarga();
		
		System.out.println("\n\n");
		
		//Periodico
		System.out.println(prof.retiraLivro(p1));
		prof.listaCarga();
		
		System.out.println("\n\n");
	
		//Bloqueio de um livro ou periodico
		prof.bloqueiaLivro(livro3, 5);
		System.out.println(livro3);
		
		//Devolver Livro
		System.out.println(interno.devolveLivro(livro2));
		System.out.println(livro2);
		
		
		//DVD - testando
		DVD dvd1 = new DVD("Velozes", 1);
		
		System.out.println("aqui: " + prof.retiraLivro(dvd1));
		System.out.println("aqui:" + prof.devolveLivro(dvd1));
		System.out.println(dvd1);
		*/
		
		/*
		DVD dvd1 = new DVD("Velozes", 1);
		DVD dvd2 = new DVD("Carros", 2);
		
		Usuarios user1 = new Usuarios();
		Items 	 item1 = new Items();
		
		
		item1.adicionar(dvd1);
		item1.adicionar(dvd2);
		item1.adicionar(livro1);
		item1.adicionar(livro2);
		item1.adicionar(p1);
		
		user1.adicionar(interno);
		user1.adicionar(externo);
		user1.adicionar(prof);
		
		
		//System.out.println(user1.remover("Marcia"));
		
		//user1.iterar();
		
		//item1.iterar(); 
		
		//System.out.println(item1.remover("Java"));
		
		
		//item1.iterar();  */
		
		Interface it = new Interface();
		it.menu();

	}

}
