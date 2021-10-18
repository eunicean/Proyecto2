package db_test;
import java.sql.*;
import java.util.*;

public class conexion {
	
	public ArrayList<String> consulta(String query) {
		//String ret = "";
		ArrayList<String> L = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				L.add(rs.getString(2));
			}
			con.close();
			return L;
		}catch(Exception e){ 
			System.out.println(e);
			return L;
		}
	}
	
}
