package um.tds.AppVideo.controlador;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import um.tds.AppVideo.dominio.RepositorioUsuario;
import um.tds.AppVideo.dominio.Usuario;
import um.tds.AppVideo.persistencia.DAOException;
import um.tds.AppVideo.persistencia.FactoriaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorUsuarioDAO;
import um.tds.AppVideo.dominio.*;

public class Controlador {
	private Usuario usuario;

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private RepositorioUsuario repositorioUsuario;
	private RepositorioVideo repositorioVideo;

	// Singleton
	private static Controlador unicaInstancia;

	public static Controlador getUnicaInstancia() {

		if (unicaInstancia == null) {
			unicaInstancia = new Controlador();
		}
		return unicaInstancia;
	}

	// Controlador
	private Controlador() {
		usuario = null;
		inicializarAdaptadores();
		inicializarRepositorios();
	}

	// Iniciamos los adaptadores
	private void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
	}

	// Iniciamos los repositorios
	private void inicializarRepositorios() {
		repositorioUsuario = RepositorioUsuario.getUnicaInstancia();
		repositorioVideo = RepositorioVideo.getUnicaInstancia();
	}

	// Metodo de obtencion de Usuario
	public Usuario getUsuario() {
		return usuario;
	}

	// Login
	public boolean login(String password, String user) {
		Usuario usuario = RepositorioUsuario.getUnicaInstancia().findUsuario(user);
		if (usuario != null && usuario.checkPassword(password)) {
			this.usuario = usuario;
			return true;
		} else {
			return false;
		}
	}

	// Logout
	public void logout() {
		this.usuario = null;
	}

	// Registrar usuario
	public void registrarUsuario(String nombre, String apellidos, String email, boolean premium, String usuario,
			String password, LocalDate fechaNac) {
		if (this.repositorioUsuario.findUsuario(usuario) == null) {
			this.usuario = new Usuario(nombre, apellidos, email, usuario, password, fechaNac, premium);
			adaptadorUsuario.addUsuario(this.usuario);
			repositorioUsuario.addUsuario(this.usuario);
		}
	}

	// Premium
	public void becomePremium() {
		if (this.usuario != null) {
			this.usuario.setPremium();
			adaptadorUsuario.modifyUsuario(usuario);
		}
	}

	// Obtener listas de videos
	public List<ListaVideos> getListas() {
		if (this.usuario != null) {
			return this.usuario.getListasVideos();
		} else {
			return null;
		}

	}
	
	// Buscar videos por etiquetas
		public Collection<Video> searchVideos(List<Etiqueta> etiqueta) {
			return this.repositorioVideo.searchVideos(etiqueta);
		}
		
		// Buscar videos por filtro
		public Collection<Video> searchVideos(FiltroVideo filtro) {
			if (this.usuario.isPremium()) {
				return this.repositorioVideo.searchVideos(filtro);
			} else {
				return null;
			}
		}

}
