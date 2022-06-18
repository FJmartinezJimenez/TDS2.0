package um.tds.AppVideo.dominio;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Usuario {

	private int id;
	private final String nombre;
	private final String apellidos;
	private final String email;
	private boolean premium;
	private final String usuario;
	private final String password;
	private final LocalDate fechaNacimiento;
	private List<ListaVideos> listasVideos;
	private  FiltroVideo filtro;

	public Usuario(String nombre, String apellidos, String email, String usuario, String password,
			LocalDate fechaNacimiento, boolean premium) {
		this.id = 0;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.premium = premium;
		this.usuario = usuario;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.filtro= new NoFiltro();
		this.listasVideos = new LinkedList<ListaVideos>();
		

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium() {
		this.premium = true;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
	
	public List<ListaVideos> getListasVideos() {
		return listasVideos;
	}

	public void setListasVideos(List<ListaVideos> listas) {
		this.listasVideos = listas;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public FiltroVideo getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroVideo filtro) {
		if (this.premium == true) {
			this.filtro = filtro;
		}
	}

	public boolean checkPassword(String password) {
		return password.equals(password);
	}

}
