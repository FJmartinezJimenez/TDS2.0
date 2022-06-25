package um.tds.AppVideo.controlador;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import um.tds.AppVideo.dominio.RepositorioUsuario;
import um.tds.AppVideo.dominio.Usuario;
import um.tds.AppVideo.persistencia.DAOException;
import um.tds.AppVideo.persistencia.FactoriaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorEtiquetaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorUsuarioDAO;
import um.tds.AppVideo.persistencia.IAdaptadorVideoDAO;
import um.tds.AppVideo.dominio.*;

public class Controlador {
	private Usuario usuario;

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;
	private IAdaptadorEtiquetaDAO adaptadorEtiqueta;
	private RepositorioUsuario repositorioUsuario;
	private RepositorioVideo repositorioVideo;
	private CatalogoEtiqueta catalogoEtiqueta;

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
		adaptadorVideo = factoria.getVideoDAO();
		adaptadorEtiqueta = factoria.getEtiquetaDAO();
	}

	// Iniciamos los repositorios
	private void inicializarRepositorios() {
		repositorioUsuario = RepositorioUsuario.getUnicaInstancia();
		repositorioVideo = RepositorioVideo.getUnicaInstancia();
		catalogoEtiqueta = CatalogoEtiqueta.getUnicaInstancia();
	}

	// Metodo de obtencion de Usuario
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void addEtiqueta(String etiqueta, Video video) {
		Etiqueta et = new Etiqueta(etiqueta);
		catalogoEtiqueta.addEtiqueta(et);
		adaptadorEtiqueta.addEtiqueta(et);
		repositorioVideo.addEtiqueta(video, et);
		adaptadorVideo.modifyVideo(video);
	}
	
	public void removeEtiqueta(Etiqueta etiqueta, Video video) {
		  video.removeEtiqueta(etiqueta);
	}

	// Login
	public boolean login(String password, String user) {
		Usuario usuario = RepositorioUsuario.getUnicaInstancia().getUsuario(user);
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
		if (this.repositorioUsuario.getUsuario(usuario) == null) {
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

	// Crear Lista Videos
	public void createList(String nombre, List<Video> lista) {
		this.usuario.addListaVideos(nombre, lista);
		adaptadorUsuario.modifyUsuario(usuario);
	}

	// Eliminar lista de videos
	public void eliminarListaVideos(String nombre) {
		ListaVideos l = new ListaVideos(nombre);
		usuario.removeLista(l);
		adaptadorUsuario.modifyUsuario(usuario);
	}

	// Añadir videos a la lista
	public void addVideotoList(String nombre, Video video) {
		this.usuario.addVideo(nombre, video);
		adaptadorVideo.modifyVideo(video);
	}

	// Eliminar video de la lista
	public void deleteVideotoList(String nombre, Video video) {
		this.usuario.deleteVideo(nombre, video);
		adaptadorVideo.modifyVideo(video);
	}

	// Devolver los videos recientes
	public List<Video> getRecientes() {
		if (usuario != null) {
			return this.usuario.getRecientes();
		} else {
			return null;
		}
	}
	
	// De forma rapido mirar
    public void generatePDF() throws FileNotFoundException, DocumentException {
        if (Controlador.getUnicaInstancia().usuario != null && Controlador.getUnicaInstancia().usuario.isPremium()) {
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("AppVideoPdf.pdf"));
            doc.open();
            for (ListaVideos lista : usuario.getListasVideos()) {
                doc.add(new Paragraph(lista.getName().toUpperCase()));
                for (Video video : lista.getVideos()) {
                    doc.add(new Paragraph(video.getTitulo() + " " + video.getNumRepro()));
                }
                doc.add(new Paragraph(" "));
            }
            doc.close();
        }
    }

	//Falta top10videos, pdf, añadir y eliminar etiqueta(metodos ya hechos en sus clases respectivas), 
	//y todo de los videos
	
	

}
