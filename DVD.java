public class DVD extends Item{
	//Atributos
	private int privilegio;

	//Metodos Especiais
	public DVD(String tit, int privilegio) {
		super(tit);
		this.privilegio = (privilegio >= 1 && privilegio <= 3) ? privilegio : 3; //codicao de cai no mais generico (Usuario Qualquer)
	}
	
	//Metodos
	public boolean alteraPrivilegio(int privilegio) {
		if (privilegio >= 1 && privilegio <= 3) {
			this.privilegio = privilegio;
			return true;
		} 
		return false;
	}
	
	private boolean verificarPrivilegio(Usuario u) {
		 if (this.privilegio == 1)
			return (u instanceof UsuarioProfessor);
		 else if (this.privilegio == 2)
			return (u instanceof UsuarioProfessor ||
					u instanceof UsuarioAluno);
		 else
			 return true;		
	}
	
	public boolean empresta(Usuario u, int prazo) {
		
		if (verificarPrivilegio(u) && super.empresta(u, 2))
			return true;
		else 
			return false;
	}
	
	public String toString() {
		if (this.privilegio == 1)		return (super.toString() + " - Apenas Professor");
		else if (this.privilegio == 2)  return (super.toString() + " - Apenas Professor e Aluno");
		else 							return (super.toString() + " - Qualquer Usuario");	
	}
	


	
}
