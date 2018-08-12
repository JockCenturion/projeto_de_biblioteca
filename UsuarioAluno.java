import java.util.Date;

public class UsuarioAluno extends Usuario {
 	private Date dataLimite;

 	public UsuarioAluno(String st, Date dt) {
 		super(st);
 		this.dataLimite=dt;
 	}
 	public void renovaCartao (Date dt) {
 		this.dataLimite=dt;
 	}

 	public boolean isRegular(){
 		Date hoje=new Date();
		return dataLimite.after(hoje);
	}

	public boolean isARenovar(){
 		return !isRegular();
	}

	public int getCotaMaxima(){
 		return (isRegular() ? 3 : super.getCotaMaxima());
	}

	public int getPrazoMaximo(){
 		return (isRegular()? 7 : super.getPrazoMaximo());
	}

	public String toString () {
 		return("Aluno " + getNome());
	}
	
	//Adicionado
	public String situacao() {
		/*return (super.situacao() 									  				  + "\n" +
				"Está Regular? " 				+ (this.isRegular()  ? "Sim" : "Nao") + "\n" +
				"Precisa Renovar Cadastro? " 	+ (this.isARenovar() ? "Sim" : "Não") + "\n" +
				"Data Limite: "					+ this.dataLimite);*/
		return ("Está apto a Retirar? " 		+ (this.isAptoARetirar() && !this.isARenovar() ? "Sim" : "Não")    	+ "\n" +
				"Precisa Devolver? "   			+ (this.isADevolver() ? "Sim" : "Não")		 	+ "\n" +
				"Está Regular? " 				+ (this.isRegular()  ? "Sim" : "Nao") 			+ "\n" +
				"Precisa Renovar Cadastro? " 	+ (this.isARenovar() ? "Sim" : "Não") 			+ "\n" +
				"Data Limite: "					+ this.dataLimite);

		
				
	}

}