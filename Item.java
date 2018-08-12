import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Item {
	private String titulo;
	private Usuario retiradoPor;
	private Date dtEmprestimo;
	private Date dtDevolucao;

	public Item (String tit) {
	 	this.titulo = tit;
	}
	
	//Adicionado
	public String getTitulo() {
		return this.titulo;
	}
	
	//Adicionado
	public Usuario getRetiradoPor() {
		return this.retiradoPor;
	}
	
	//Adicionado
	public Date getDtEmprestimo() {
		return this.dtEmprestimo;
	}
	
	//Adicionado
	public Date getDtDevolucao() {
		return this.dtDevolucao;
	}
	
	
	public boolean isDisponivel() {
		return this.retiradoPor == null;
	}
	
	public boolean isEmprestado() {
 		return !(this.retiradoPor==null);
	}
	
    public boolean isEmAtraso() {
		Date hoje=new Date();
		return(isEmprestado()&&
			  dtDevolucao.before(hoje));
    }  
    
	public boolean empresta(Usuario u, int prazo) {
		 GregorianCalendar cal = new GregorianCalendar();
		 if (this.isDisponivel()) { 
			 this.retiradoPor = u;
			 this.dtEmprestimo = cal.getTime();
			 cal.add(Calendar.DATE, prazo);
			 this.dtDevolucao=cal.getTime();
		 	return true;
		 }
		 return false;
	}
	
	public boolean retorna (Usuario u) {
		if (u == this.retiradoPor) {
		 	this.retiradoPor=null;
			return true;
		}
			return false;
	} 
	
	protected String dma(Date dt) {		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return  cal.get(Calendar.DATE)	+  	  "/"+
			   (cal.get(Calendar.MONTH)	+ 1) +"/"+
		        cal.get(Calendar.YEAR);
	} 
	
	public String toString() {
		String st = new String();
		if(isDisponivel()){
			return getTitulo()+ " disponivel";
		}

		if(isEmprestado()){
			st = " retirado por " + getRetiradoPor() + " em " + dma(getDtEmprestimo())+
			     " ate " + dma(getDtDevolucao());
		}
	
		return getTitulo()+st;
	}


	


	
}
