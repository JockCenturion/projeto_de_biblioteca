public class UsuarioProfessor extends Usuario {
	
 	public UsuarioProfessor(String st) {
 		super(st);
 	}
 	public boolean bloqueiaLivro(Livro it, int prazo) {
 		return it.bloqueia((Usuario)this, prazo);
 	}
 	public boolean desbloqueiaLivro (Livro it) {
 		return it.desbloqueia((Usuario)this);
 	}

 	public int getCotaMaxima(){
		return 5;
	}
	public int getPrazoMaximo(){
		return 14;
	}
	public boolean isProfessor(){
		return true;
	}
	public String toString(){
		return "Prof. "+super.getNome();
	}

	
}