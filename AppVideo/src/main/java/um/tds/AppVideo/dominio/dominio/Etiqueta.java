package um.tds.AppVideo.dominio;

public class Etiqueta {
	private String nombre;
	private int id;

	public Etiqueta(String nombre) {
		this.nombre = nombre;
		this.id = 0;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
