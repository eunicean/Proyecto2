import java.sql.*;
import java.util.*;

import modelos.Ingredientes;
import modelos.Receta;

public class Platillo extends Receta{
	//agregar categoria para representar el tipo de platillos

	public Platillo (String nombre, Ingredientes[] listaIngredientes) {
		super(nombre, listaIngredientes);
		// TODO Auto-generated constructor stub
		String Query = "\'" + nombre +"\',";
		for (int i = 0; i < super.getListaIngredientes().length; i++) {
			if(i == super.getListaIngredientes().length - 1) {
				Query += "\'" + super.getListaIngredientes()[i].getNombre() + "\', \'" + super.getListaIngredientes()[i].getCantidades()+"\'";
				break;
			}
			Query += "\'" + super.getListaIngredientes()[i].getNombre() + "\', \'" + super.getListaIngredientes()[i].getCantidades()+"\', ";
		}
		
		InsertarReceta("CALL add_receta(" + Query + ")");
	}
	
	public void InsertarReceta(String query) {
		System.out.println(query);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos","root","");
			PreparedStatement stm = con.prepareStatement(query);
			stm.execute();
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}

	@Override
	public void proceso() { //metodo para comprobar herencia
		System.out.println("Aqui vamos a elaborar la pizza");
		System.out.println(super.getNombre() );
		System.out.println(super.getListaIngredientes().length);
	}
	
}
