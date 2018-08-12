public class Periodico extends Livro{
	
	public Periodico(String tit) {
		super(tit);
	}
	
	public boolean empresta (Usuario u, int prazo) {
		if (u.isProfessor()) return super.empresta(u, prazo);
		return false;
	}	
}
