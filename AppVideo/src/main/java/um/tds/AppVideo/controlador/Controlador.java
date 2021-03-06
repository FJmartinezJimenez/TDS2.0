package um.tds.AppVideo.controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Collection;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import um.tds.AppVideo.persistencia.AdaptadorVideo;
import um.tds.AppVideo.persistencia.DAOException;
import um.tds.AppVideo.persistencia.FactoriaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorEtiquetaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorUsuarioDAO;
import um.tds.AppVideo.persistencia.IAdaptadorVideoDAO;
import um.tds.componente.CargadorVideos;
import um.tds.componente.VideoListener;
import um.tds.componente.Videos;
import um.tds.componente.VideosEvent;
import um.tds.AppVideo.AppVideo;
import um.tds.AppVideo.dominio.*;

public class Controlador implements VideoListener {
	private Usuario usuario;

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;
	private IAdaptadorEtiquetaDAO adaptadorEtiqueta;
	private RepositorioUsuario repositorioUsuario;
	private RepositorioVideo repositorioVideo;
	private CatalogoEtiqueta catalogoEtiqueta;
	private CargadorVideos cargadorVideos;

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
		usuario =null;
		inicializarAdaptadores();
		inicializarRepositorios();
		cargadorVideos = CargadorVideos.getUnicaInstancia();
		cargadorVideos.attach(this);
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
	
	// USUARIOS
	
	// Login
	public boolean login(String password, String user) {
		Usuario usu = RepositorioUsuario.getUnicaInstancia().getUsuario(user);
		if (usu != null && usu.checkPassword(password)) {
			this.usuario = usu;
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
	public void registrarUsuario(String nombre, String apellidos, String email, String usuario,
			String password, LocalDate fechaNac, boolean premium) {
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
	
	//VIDEOS 
	
	// Reproducir video a traves de un video 
	public void playVideo(String url) {
		Video v = findVideo(url);
		AppVideo.videoWeb.playVideo(url);
		v.incrementarnumRepro();
		adaptadorVideo.modifyVideo(v);
		usuario.addVideoRecientes(v);
		adaptadorUsuario.modifyUsuario(usuario);

	}
	
	//Parar un video
	public void stopVideo() {
		AppVideo.videoWeb.cancel();
	}
	
	public Video findVideo(String url) {
		return repositorioVideo.getVideo(url);

	}
	
	// Buscar videos por etiquetas
	public Collection<Video> searchVideos(List<String> etiqueta) {
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
	
	//Buscar videos por titulo
	public Collection<Video> searchVideos(String titulo) {
		return repositorioVideo.searchVideos(titulo);
	}
	//Buscar videos por titulo,filtro y etiqueta
	public Collection<Video> searchVideos(List<String> e, String titulo) {
		return repositorioVideo.searchVideos(usuario.getFiltro(), titulo, e);

	}


	// Devolver los videos recientes
	public List<Video> getRecientes() {
		if (usuario != null) {
			return this.usuario.getRecientes();
		} else {
			return null;
		}
	}
	
	//Devuelve la lista de los 10 videos mas vistos
	public List<Video> getTop10() {
		return repositorioVideo.getTop_TenVideos();
	}

	
	// A??adir etiqueta
	public void addEtiqueta(String etiqueta, Video video) {
		Etiqueta et = new Etiqueta(etiqueta);
		catalogoEtiqueta.addEtiqueta(et);
		adaptadorEtiqueta.addEtiqueta(et);
		repositorioVideo.addEtiqueta(video, et);
		adaptadorVideo.modifyVideo(video);
	}
	
	// Eliminar etiqueta
	public void removeEtiqueta(Etiqueta etiqueta, Video video) {
		  video.removeEtiqueta(etiqueta);
	}
	
	//ETIQUETAS
	
	//Obtenemos todas las etiquetas
	public List<Etiqueta> getEtiquetas(){
		return catalogoEtiqueta.getEtiquetas();
		
	}

	//LISTAS
	// Crear Lista Videos
	public ListaVideos createList(String nombre) {
		ListaVideos l = this.usuario.addListaVideos(nombre);
		adaptadorUsuario.modifyUsuario(usuario);
		return l;
	}

	// Eliminar lista de videos
	public void eliminarListaVideos(String nombre) {
		ListaVideos l = new ListaVideos(nombre);
		usuario.removeLista(l);
		adaptadorUsuario.modifyUsuario(usuario);
	}
	
	public ListaVideos findLista(String nombre) {
		ListaVideos list = null;
		for (ListaVideos l : usuario.getListasVideos()) {
			if (l.getName().equals(nombre)) {
				list=l;
			}
		}
		return list;
	}

	// Obtener listas de videos
	public List<ListaVideos> getListas() {
		if (this.usuario != null) {
			return this.usuario.getListasVideos();
		} else {
			return null;
		}

	}
	
	// A??adir videos a la lista
	public void addVideotoList(String nombre, Video video) {
		this.usuario.addVideo(nombre, video);
		adaptadorVideo.modifyVideo(video);
	}

	// Eliminar video de la lista
	public void deleteVideotoList(String nombre, Video video) {
		this.usuario.deleteVideo(nombre, video);
		adaptadorVideo.modifyVideo(video);
	}
	
	//Devolver los videos de una lista
	public List<Video> getLista(String lista) {
		List<Video> v= new LinkedList<Video>();
		for (ListaVideos l : usuario.getListasVideos()) {
			if (l.getName().equals(lista)) {
				v=l.getVideos();
			}
		}
		return v;
	}
	
	

	//PDF
	
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
    
    //CARGADOR VIDEOS 

	// Cargamos los videos en el servidor y catalogo local
	@Override
	public void enteradoCambios(EventObject e) {
		if (e instanceof VideosEvent) {
			try {
				AdaptadorVideo adaptadorVideo = (AdaptadorVideo) FactoriaDAO.getInstancia().getVideoDAO();
			} catch (DAOException e1) {

				e1.printStackTrace();
			} 
			for (Video v : getVideosFromXml(((VideosEvent) e).getVideos())) {
				adaptadorVideo.addVideo(v);
				repositorioVideo.addVideo(v);
			}
		}
	}

	public static List<Video> getVideosFromXml(Videos videos) {
		List<Video> l = new LinkedList<Video>();
		for (um.tds.componente.Video v : videos.getVideo()) {
			Video vid = new Video(v.getURL(), v.getTitulo());
			vid.addEtiquetasString(v.getEtiqueta());
			l.add(vid);
		}
		return l;

	}

	public boolean getVideosFromXml(String xml) {
		return cargadorVideos.setFileVideo(xml);
	}

	public ListaVideos createList(String name, List<Video> videos) {
		ListaVideos l = this.usuario.addListaVideos(name,videos);
		adaptadorUsuario.modifyUsuario(usuario);
		return l;
		
	}

	
	
    
}
