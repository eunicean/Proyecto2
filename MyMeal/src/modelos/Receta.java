package modelos;
import java.util.*;

//clase abstracta para herencia.
public  class Receta {
	private String nombre;
	private ArrayList<Ingredientes> ListaIngredientes;
	private String id_receta ="0";
	
	
	public ArrayList<Ingredientes> getListaIngredientes() {
		return ListaIngredientes;
	}


	public void setListaIngredientes(ArrayList<Ingredientes> listaIngredientes) {
		ListaIngredientes = listaIngredientes;
	}


	public Receta(String nombre) {
		this.nombre = nombre;
		this.ListaIngredientes = new ArrayList<Ingredientes>();
	}
	
	public Receta(String nombre, String id) {
		this.nombre = nombre;
		this.ListaIngredientes = new ArrayList<Ingredientes>();
		this.id_receta = id;
	}


//	public abstract void proceso();

	//getters setters
	public String getNombre() {
		return nombre;
	}
//
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void add_ingrediente(Ingredientes n_ingrd) {
		ListaIngredientes.add(n_ingrd);
	}
	
	public void imprimir() {
		System.out.println("");
		System.out.println("====== "+ this.id_receta +" - "+this.nombre+" ======");
		for (Ingredientes ingrediente : ListaIngredientes) {
			ingrediente.imprimir();
		}
	}
	
	public String imprimir_p_query() {
		return "'" + this.nombre+"'," + ListaIngredientes.get(0).imprimir_p_query() + "," + ListaIngredientes.get(1).imprimir_p_query() + "," + ListaIngredientes.get(2).imprimir_p_query();
		
	}
	
	public boolean tieneingrediente(String ingred) {
		for (Ingredientes ingredientes : ListaIngredientes) {
			if(ingredientes.getNombre().equalsIgnoreCase(ingred.trim())) {
				return true;
			}
		}
		return false;
	}
	
	public void imprimir_c_ingrediente(String nombre_ingrediente) {
		if(tieneingrediente(nombre_ingrediente)) {
			this.imprimir();
		}
		
	}
	
}