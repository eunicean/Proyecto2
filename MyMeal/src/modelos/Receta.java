package modelos;
import java.util.*;

//clase abstracta para herencia.
public abstract class Receta {
	private String nombre;
	private Ingredientes[] ListaIngredientes;
	
	public Receta(String nombre, Ingredientes[] listaIngredientes) {
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

	public Ingredientes[] getListaIngredientes() {
		return ListaIngredientes;
	}

	public void setListaIngredientes(Ingredientes[] listaIngredientes) {
		ListaIngredientes = listaIngredientes;
	}
	
}
