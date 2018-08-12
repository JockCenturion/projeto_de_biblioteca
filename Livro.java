import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Livro extends Item{
	private Usuario bloqueadoPor;
	private Date dtBloqueio;
	private Date dtDesbloqueio;

	public Livro (String tit) {
	 	super(tit);
	}

	public boolean isDisponivel() {
		Date hoje=new Date();
	 	return super.isDisponivel() &&
	 		   (this.bloqueadoPor==null||this.dtDesbloqueio.before(hoje));
	}


	public boolean isBloqueado() {
		Date hoje=new Date();
		return   super.isDisponivel() 		&&
			   !(this.bloqueadoPor==null)   &&
			   !(this.dtDesbloqueio.before(hoje));
	}


	public boolean bloqueia (Usuario u,int prazo){
		 GregorianCalendar cal = new GregorianCalendar();
		 if(this.isDisponivel()&& u.isProfessor()) {
			this.bloqueadoPor=u;
			this.dtBloqueio=cal.getTime();
			cal.add(Calendar.DATE, (prazo>20?20:prazo));
			this.dtDesbloqueio=cal.getTime();
		 	return true;
		 }
		 return false;
	}



	public boolean desbloqueia (Usuario u) {
		if (u == this.bloqueadoPor) {
	 		this.bloqueadoPor=null;
	 		return true;
	 	}
	 	return false;
	}
	
	public String toString() {
		if (isBloqueado())
			return ( super.toString() + " bloqueado por " + bloqueadoPor + " em " + dma(dtBloqueio)+
					" ate " + dma(dtDesbloqueio) );
		else 
			return super.toString();
	}
	
	

	
	
	


}