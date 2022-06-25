package um.tds.AppVideo.dominio;
import java.util.List;
public class Video {
	private int id;
	private String url;
	private String titulo;
	private int numRepro;
	private List<Etiqueta> etiquetas;

	public Video(String url, String titulo, List<Etiqueta> etiquetas) {
		this.id = 0;
		this.url = url;
		this.titulo = titulo;
		this.numRepro = 0;
		this.etiquetas = etiquetas;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumRepro() {
		return numRepro;
	}

	public void setNumRepro(int numRepro) {
		this.numRepro = numRepro;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public void addEtiqueta(Etiqueta etiqueta) {
		etiquetas.add(etiqueta);
	}

	public void removeEtiqueta(Etiqueta etiqueta) {
		etiquetas.remove(etiqueta);

	}

	public void incrementarnumRepro() {
		this.numRepro += 1;

	}
	

	public int checkEtiqueta(List<Etiqueta> etiquet) {
		int contador=0;
		for (Etiqueta etiqueta : this.etiquetas) {
			for (Etiqueta et : etiquet) {
				if (et.equals(etiqueta)) {
					contador++;
				}
			}
		}
		return contador;
	}
}
