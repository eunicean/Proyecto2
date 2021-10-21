import java.util.*;

import modelos.Ingredientes;
//ejemplo del uso de las clases
public class Main {
	public static void main(String[] args) {
		
		
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		boolean salir_sesion = false;
		String usuario = "", contrasenia = "";
		int opcion;
		
		Menu menu = new Menu();
		menu.menu();

		/*while(!salir) {
			System.out.println(" -- Inicio de Sesion -- ");
			System.out.println("Ingrese el usuario");
			usuario = sn.nextLine();
			System.out.println("");
			System.out.println("Ingrese la contrasenia");
			contrasenia = sn.nextLine();
			System.out.println("");
			Usuarios user = new Usuarios(usuario, contrasenia);
			if(user.VerificarUsuario()) {
				//verificar rol
				System.out.println("--------------------------");
				System.out.println("Bienvenido al menu de inicio => " + user.getUsuario());
				System.out.println("--------------------------");
	            System.out.println("1. Agregar Receta");
	            System.out.println("2. Salir");
	            try {
	            	 
	                System.out.println("Escribe una de las opciones");
	                opcion = sn.nextInt();
	 
	                switch (opcion) {
	                    case 1:
	                        System.out.println("Has seleccionado la opcion 1");
	                        break;
	                    case 2:
	                        System.out.println("Has seleccionado la opcion 2");
	                        break;
	                    case 3:
	                        System.out.println("Has seleccionado la opcion 3");
	                        break;
	                    case 4:
	                        salir = true;
	                        break;
	                    default:
	                        System.out.println("Solo números entre 1 y 4");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Debes insertar un número");
	                sn.next();
	            }
				
				salir = true;
				System.out.println("Adios ....");
			}
			
			
		}*/
		/*
		Ingredientes[] ListaIngrdientes = new Ingredientes[3];
		ListaIngrdientes[0] = (new Ingredientes("Chocolate","1 libra"));
		ListaIngrdientes[1] = (new Ingredientes("",""));
		ListaIngrdientes[2] = (new Ingredientes("",""));
		
		Platillo p1 = new Platillo("Crepa Choco", ListaIngrdientes);
		
		*/
		System.out.println("final");
		
		/*for(int i=ListaIngrdientes.size()-1; i>=0; i--) {
			
			System.out.println(ListaIngrdientes.get(i).getNombre() +" / "+ ListaIngrdientes.get(i).getCantidades());
		}
		System.out.println(ListaIngrdientes.size());*/
	}
	
}
