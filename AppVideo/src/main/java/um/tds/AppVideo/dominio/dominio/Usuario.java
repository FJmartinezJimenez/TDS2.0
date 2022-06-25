package um.tds.AppVideo.dominio;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import um.tds.AppVideo.persistencia.DAOException;
import um.tds.AppVideo.persistencia.FactoriaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorListaVideosDAO;

public class Usuario {
	private static final int NUM_RECIENTES = 5;
	private static IAdaptadorListaVideosDAO adaptadorListaVideosDAO = null;
	private int id;
	private final String nombre;
	private final String apellidos;
	private final String email;
	private boolean premium;
	private final String usuario;
	private final String password;
	private final LocalDate fechaNacimiento;
	private List<ListaVideos> listasVideos;
	private LinkedList<Video> recientes;
	private FiltroVideo filtro;

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
		this.listasVideos = new LinkedList<ListaVideos>();
		this.recientes = new LinkedList<Video>();
		this.filtro = new NoFiltro();
		if (adaptadorListaVideosDAO == null) {
			try {
				adaptadorListaVideosDAO = FactoriaDAO.getInstancia().getListaVideosDAO();
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}

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

	public List<Video> getRecientes() {
		return recientes;
	}

	public void setRecientes(LinkedList<Video> list) {
		this.recientes = list;
	}

	public List<ListaVideos> getListasVideos() {
		return listasVideos;
	}

	public void setListasVideos(List<ListaVideos> listas) {
		this.listasVideos = listas;
	}

	public boolean checkPassword(String password) {
		return password.equals(password);
	}

	public boolean addListaVideos(String nombre, List<Video> videos) {
		ListaVideos list = new ListaVideos(nombre, videos);
		adaptadorListaVideosDAO.addListaVideos(list);
		return this.listasVideos.add(list);
	}

	public boolean removeLista(ListaVideos lista) {
		adaptadorListaVideosDAO.removeListaVideo(lista);
		return listasVideos.remove(lista);

	}

	// TODO Con streams si se puede
	public void addVideo(String nombre, Video video) {
		for (ListaVideos l : this.listasVideos) {
			if (l.getName().equals(nombre)) {
				l.addVideo(video);
				adaptadorListaVideosDAO.modifyListaVideo(l);
			}
		}

	}

	// TODO Con streams si se puede
	public void deleteVideo(String nombre, Video video) {
		for (ListaVideos l : this.listasVideos) {
			if (l.getName().equals(nombre)) {
				l.removeVideo(video);
				adaptadorListaVideosDAO.modifyListaVideo(l);
			}
		}

	}

	public void addVideoRecientes(Video video) {
		if (recientes.size() >= NUM_RECIENTES) {
			recientes.removeLast();
		}
		recientes.addFirst(video);
	}

}

