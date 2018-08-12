import java.util.Scanner;
import java.util.Date;


public class Interface {
	private Items acervo; 
	private Usuarios users;
	private Scanner input;
	
	public Interface() {
		acervo = new Items();
		users  = new Usuarios();
		input  = new Scanner(System.in);
	}
	

	public void menu() {
		int op;
		do {
			System.out.println("\t\tMenu  												     \n" + 
					   			"\t\t1) Modo Administrador 2) Modo Atendimento 3) Sair do Sistema3");
	
			op = input.nextInt();
			if (op == 1)
				this.menuAdm();
			else if (op == 2)
				this.menuAtendimento();
			
		} while(op != 3);
		
	}
	
	private void menuAdm() {
		System.out.println("\t\tMenu Administrador 			\n" +
				   		   "\t\t1)Cadastramento	2)Remocao 	\n");
		int op = input.nextInt();
		
		if (op == 1) {
			System.out.println("\t\tMenu Cadastramento      \n" +
							   "\t\t1)Usuarios	2)Acervo	\n");
			op = input.nextInt();
			
			if (op == 1) {
				System.out.println("\t\tQual tipo de Usuario? \n"    + 
									"\t\t1)Externo 2)Aluno 3)Professor");
				
				op = input.nextInt();
				
				if (op == 1)
					this.users.adicionar(new Usuario(input.next()));
				else if (op == 2)
					this.users.adicionar(new UsuarioAluno(input.next(), new Date()));
				else if (op == 3)
					this.users.adicionar(new UsuarioProfessor(input.next()));
				
				users.iterar();	//Provisorio
				
				
			} else if (op == 2) {
				System.out.println("\t\tQual tipo de Acervo? \n" + 
								   "\t\t1)Livro 2)DVD 3)Periodico");
				op = input.nextInt();
				
				if (op == 1) {
					input.nextLine();			//Limpar buffer
					System.out.println("\t\tNome: ");
					this.acervo.adicionar(new Livro(input.nextLine()));	
				} else if (op == 2) {
					
					System.out.println("\t\tNome: ");
					String nome = input.next();
					System.out.println("\t\tQual Nivel de Privilegio? \n" + 
							   		   "\t\t1)Apenas Professores 2)Professores e Alunos 3)UsuarioQulquer");
					int privilegio = input.nextInt();
					
					this.acervo.adicionar(new DVD(nome, privilegio));
				} else if (op == 3) 
					this.acervo.adicionar(new Periodico(input.next()));
				
				acervo.iterar(); //Provisorio
					
			}
			
		} else if (op == 2){
			System.out.println("\t\tMenu Remocao      		\n" +
					   		   "\t\t1)Usuarios	2)Acervo	\n");
			op = input.nextInt();
			
			if (op == 1) 
				users.remover(input.next());
			else if (op == 2)
				acervo.remover(input.next());
			
			users.iterar();		//Provisorio
			acervo.iterar();	//Provisorio
				
		}	
	}
	
	private void menuAtendimento() {	
		if (users.dimensao() != 0 && acervo.dimensao() != 0) {
			System.out.println("\t\tMenu Usuário  	\n" +
					   		   "\t\t1)Externo 2)Aluno 3)Professor");
			
			int op = input.nextInt();
			System.out.println("\t\tUsuario: ");
			Usuario user = users.buscar(input.next());
	
			
			if (user != null) {
				if (op == 1) {
					System.out.println("\t\t1) Retirar Item 2) Devolver Item 3) Consultar Situaçao");
					op = input.nextInt();
					operacoesUser(user, op);
					
				} else if (op == 2 && user instanceof UsuarioAluno) {		
					System.out.println("\t\t1) Retirar Item 2) Devolver Item 3) Consultar Situaçao 4) Renovar Cadastro");
					op = input.nextInt();
					UsuarioAluno userAluno = (UsuarioAluno) user;
					
					if (op == 1 || op == 2 || op == 3) {
						operacoesUser(user, op);
					} else if (op == 4) {
						System.out.println("\t\tRepectivamente: ano/ mes / dia");
						userAluno.renovaCartao(new Date(input.nextInt(), input.nextInt() - 1, input.nextInt()));
					}
						
				} else if (op == 3 && user instanceof UsuarioProfessor)  { 
					System.out.println("\t\t1)Retirar Item 2)Devolver Item 3)Consultar Situaçao 4)Bloquear 5)Desbloquear");
					op = input.nextInt();
					UsuarioProfessor userProf = (UsuarioProfessor) user;
					
					if (op == 1 || op == 2 || op == 3) {
						operacoesUser(user, op);
					} else if (op == 4) {
						System.out.println("\t\tRespectivamente: Titulo e Prazo");
						Livro livro = (Livro) acervo.buscar(input.next());
						
						if (livro != null && livro instanceof Livro) {
							System.out.println(livro.toString());
							userProf.bloqueiaLivro(livro, input.nextInt());
							System.out.println(livro.toString());
						}
							
						
					} else if (op == 5) {
						Livro livro = (Livro) acervo.buscar(input.next());
						
						if (livro != null && livro instanceof Livro) {
							System.out.println(livro.toString());
							userProf.desbloqueiaLivro(livro);
							System.out.println(livro.toString());
						}
							
					}
				}

			} else {
				System.out.println("Usuario Inexistente!");
			}
				
			
		} else {
			System.out.println("\t\tCadastre um Usuario e um Item no Sistema!\n");
		}
			
	} 
	
	
	private void operacoesUser(Usuario user, int op) {
			if (op == 1 || op == 2) {
				System.out.println("\t\tTitulo: ");
				Item    item = acervo.buscar(input.next());
				
				if (item != null) {
					System.out.println(item.toString());
				
					if (op == 1 ) {
						user.retiraLivro(item);
						System.out.println(item.toString());
					} else  {
						user.devolveLivro(item);
						System.out.println(item.toString());
					} 
				
				}else 
					System.out.println("Titulo Inexistente!");
			} else if (op == 3) {
				System.out.println(user.situacao());
				user.listaCarga();	
			} 

	}

	

	
	
	
}
