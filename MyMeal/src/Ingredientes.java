
public class Ingredientes {
	private String Nombre;
	private String Cantidades;
	
	public Ingredientes(String nombre, String cantidades) {
		this.Nombre = nombre;
		this.Cantidades = cantidades;
	}
	//getters setter
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getCantidades() {
		return Cantidades;
	}
	public void setCantidades(String cantidades) {
		this.Cantidades = cantidades;
	}
}
