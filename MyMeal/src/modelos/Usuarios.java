package modelos;

public class Usuarios {
	private String usuario;
	private String contrasenia;
	private String rol;
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Usuarios(String usuario, String contrasenia,String rol) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}
	
	public Usuarios(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = "0";
	}

	public boolean VerificarUsuario() {
		if(this.getUsuario().equals("eu") && this.getContrasenia().equals("123")) {
			return true;
		}
		return false;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
