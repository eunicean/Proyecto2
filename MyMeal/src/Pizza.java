import java.util.ArrayList;

public class Pizza extends Receta{
	//agregar categoria para representar el tipo de platillos

	public Pizza(String nombre, ArrayList<Ingredientes> listaIngredientes) {
		super(nombre, listaIngredientes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void proceso() { //metodo para comprobar herencia
		System.out.println("Aqui vamos a elaborar la pizza");
		System.out.println(super.getNombre() );
		System.out.println(super.getListaIngredientes().size());
	}
	
}
