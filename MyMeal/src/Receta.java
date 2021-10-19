import java.util.*;

//clase abstracta para herencia.
//todo mal
public abstract class Receta {
	private String nombre;
	private ArrayList<Ingredientes> ListaIngredientes;
	
	public Receta(String nombre, ArrayList<Ingredientes> listaIngredientes) {
		this.nombre = nombre;
		this.ListaIngredientes = listaIngredientes;
	}

	public abstract void proceso();

	//getters setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Ingredientes> getListaIngredientes() {
		return ListaIngredientes;
	}

	public void setListaIngredientes(ArrayList<Ingredientes> listaIngredientes) {
		ListaIngredientes = listaIngredientes;
	}
	
}
