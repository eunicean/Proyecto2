import java.util.*;
//ejemplo del uso de las clases
public class Main {
	public static void main(String[] args) {
		System.out.println("Anotar");
		ArrayList<Ingredientes> ListaIngrdientes = new ArrayList<>();
		ListaIngrdientes.add(new Ingredientes("Maiz","1 libra"));
		ListaIngrdientes.add(new Ingredientes("Apio","2 libra"));
		ListaIngrdientes.add(new Ingredientes("frijol","3 libra"));
		
		Pizza p1 = new Pizza("Jamon", ListaIngrdientes); //crear objeto, darle nombre, lista de ingredientes y obtener el proceso
		p1.proceso();
		
		Pizza p2 = new Pizza("Hawaiana", ListaIngrdientes);
		p2.proceso();
		
		
		/*for(int i=ListaIngrdientes.size()-1; i>=0; i--) {
			
			System.out.println(ListaIngrdientes.get(i).getNombre() +" / "+ ListaIngrdientes.get(i).getCantidades());
		}
		System.out.println(ListaIngrdientes.size());*/
	}
	
}
