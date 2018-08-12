import java.util.ArrayList;
import java.util.Iterator;

public class Usuarios {
	private ArrayList<Usuario> usuarios;
	
	public Usuarios() {
		usuarios = new ArrayList<>();
	}
	
	public void adicionar(Usuario user) {
		usuarios.add(user);
	}
	
	public boolean remover(String nome) {
		Iterator<Usuario> it = this.usuarios.iterator();
		
		while (it.hasNext()) {
			Usuario user = it.next();
			
			if (user.getNome().equalsIgnoreCase(nome)) {
				it.remove();
				return true;
			}
		}
		
		return false;
	}
	
	
	public Usuario buscar(String nome) {
		Iterator<Usuario> it = this.usuarios.iterator();
		
		while (it.hasNext()) {
			Usuario user = it.next();
			
			if (user.getNome().equalsIgnoreCase(nome))
				return user;
		}
		
		return null;
	}
	
	public int dimensao() {
		return this.usuarios.size();
	}
	
	public void iterar() {
		Iterator<Usuario> it = this.usuarios.iterator();
		
		while (it.hasNext()) 
			System.out.println(it.next());
		
	}
}
