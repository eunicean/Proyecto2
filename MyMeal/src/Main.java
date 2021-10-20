import java.util.*;

import modelos.Ingredientes;
//ejemplo del uso de las clases
public class Main {
	public static void main(String[] args) {
		
		Ingredientes[] ListaIngrdientes = new Ingredientes[3];
		ListaIngrdientes[0] = (new Ingredientes("Chocolate","1 libra"));
		ListaIngrdientes[1] = (new Ingredientes("",""));
		ListaIngrdientes[2] = (new Ingredientes("",""));
		
		Platillo p1 = new Platillo("Crepa Choco", ListaIngrdientes);
		
		
		System.out.println("final");
		
		/*for(int i=ListaIngrdientes.size()-1; i>=0; i--) {
			
			System.out.println(ListaIngrdientes.get(i).getNombre() +" / "+ ListaIngrdientes.get(i).getCantidades());
		}
		System.out.println(ListaIngrdientes.size());*/
	}
	
}
