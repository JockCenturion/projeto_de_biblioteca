import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
	private String nome;
	private ArrayList<Item> livrosRetirados;
	
	public Usuario(String st) {
		this.nome = st;
		livrosRetirados = new ArrayList<>();
	}
	
	public boolean retiraLivro(Item it) {
		if (this.isAptoARetirar()) {
			if (it.empresta(this, getPrazoMaximo())) {
				this.livrosRetirados.add(it);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean devolveLivro(Item it) {
		if (it.retorna(this)){
			this.livrosRetirados.remove(it);
			return true;
		}
		else{
			return false;
		}
	}

	public int getCotaMaxima() {
		return 2;
	}
	
	public int getPrazoMaximo() {
		return 4;
	}
	
	public boolean isADevolver() {
		return ( (this.livrosRetirados.size() >= this.getCotaMaxima()) 
				  || this.temPrazoVencido());  //não precisa do ternario
	}
	
	public boolean isAptoARetirar() {
		return (!(this.isADevolver()));
	}
	
	public boolean temPrazoVencido() {
		Iterator<Item> it = livrosRetirados.iterator();
		while (it.hasNext()) 
			if (it.next().isEmAtraso())
					return true;
		return false;
	}
	

	public boolean isProfessor(){
		return false;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String toString(){
		return ("Usuario "	+ nome);
	}
	
	public void listaCarga(){
		System.out.println(this.toString()+" Limite: "+ this.getCotaMaxima()+
						   " Carga atual: " + this.livrosRetirados.size());
		
		Iterator<Item> it = this.livrosRetirados.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
		
	}
	
	//Adicionado
	public int getQtdLivros() {
		return this.livrosRetirados.size();
	}
	

	public String situacao() {
		return ("Está apto a Retirar? " + (this.isAptoARetirar() ? "Sim" : "Não")    + "\n" +
				"Precisa Devolver? "    + (this.isADevolver() ? "Sim" : "Não")			     );
	}
	
	/*
	public String situacao() {
		return ("EH professor? " 												 + "\n" + 
				"Está apto a Retirar? " + (this.isAptoARetirar() ? "Sim" : "Não")    + "\n" +
				"Precisa Devolver? "    + (this.isADevolver() ? "Sim" : "Não")		 + "\n" +
				"Cota: " + this.getQtdLivros() + "/" + this.getCotaMaxima());				//Diferença entre metodos herdados (getQtd..) e metodos sobreescritos(getCota..)
	}*/

}
