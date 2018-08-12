import java.util.ArrayList;
import java.util.Iterator;

public class Items {
	private ArrayList<Item> items;
	
	public Items() {
		items = new ArrayList<>();
	}
	
	public void adicionar(Item elemento) {
		this.items.add(elemento);
	}
	
	public boolean remover(String nome) {
		Iterator<Item> it = this.items.iterator();
		
		while (it.hasNext()) {
			Item acervo = it.next();
			
			if (acervo.getTitulo().equalsIgnoreCase(nome)) {
				it.remove();
				return true;
			}	
		}
		
		return false;
	}
	
	
	public Item buscar(String nome) {
		Iterator<Item> it = this.items.iterator();
		
		while (it.hasNext()) {
			Item item = it.next();
			
			if (item.getTitulo().equalsIgnoreCase(nome))
				return item;
		}
		return null;
	}
	public int dimensao() {
		return this.items.size(); 
	}
	
	public void iterar() {
		Iterator<Item> it = this.items.iterator();
		
		while (it.hasNext()) 
			System.out.println(it.next());
		
		
	}
	

}
