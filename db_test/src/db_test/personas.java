package db_test;
import java.util.ArrayList;

public class personas {
	private conexion Conec = new conexion();
	
	public void get_personas() {
		try {
			String query = "SELECT * FROM personas";
			ArrayList<String> rs = this.Conec.consulta(query);
			System.out.println(rs.get(1));
		}catch(Exception e){ System.out.println(e);}
	}
	
}
