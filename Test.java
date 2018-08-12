import java.util.Date;
import java.util.Calendar;


public class Test {
	public static void main(String[] args) {
		
		Livro livro1 = new Livro("Java");
		Usuario user1 = new Usuario("Jock");
		
		System.out.println(livro1);
		System.out.println(user1);
		
		user1.retiraLivro(livro1);
		
		
		System.out.println(livro1);
		System.out.println(user1);
		
		
		/*
		Calendar cal = Calendar.getInstance();
	
		int ano = cal.get(Calendar.YEAR); 
		int dia = cal.get(Calendar.DATE);
		int mes = cal.get(Calendar.MONTH) + 1;
		//int dia_do_mes = cal.get(Calendar.DAY_OF_MONTH);
		int hora = cal.get(Calendar.HOUR);
		
		System.out.println("Hoje é: " + dia + "/" + mes + "/" + ano);
		System.out.println(hora); 
		System.out.println(cal.getTime()); */
		
		
	}
}
