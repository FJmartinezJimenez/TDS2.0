package um.tds.AppVideo.dominio;

import java.util.*;

import um.tds.AppVideo.persistencia.DAOException;
import um.tds.AppVideo.persistencia.FactoriaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorVideoDAO;

public class RepositorioVideo {
	Map<String, Video> videos;

	private FactoriaDAO dao;
	private IAdaptadorVideoDAO adaptadorVideo;

	private static RepositorioVideo unicaInstancia = new RepositorioVideo();

	public static RepositorioVideo getUnicaInstancia() {
		return unicaInstancia;
	}

	public RepositorioVideo() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorVideo = dao.getVideoDAO();
			this.videos = new HashMap<String, Video>();
			this.cargarCatalogo();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

	// Obtenemos el video
	public Video getVideo(String video) {
		return videos.get(video);
	}

	//Añadimos un video
	public void addVideo(Video video) {
			videos.put(video.getUrl(), video);
	}
	// Borrar video
	public void removeVideo(Video video) {
			videos.remove(video.getUrl());
	}

	// TODO Con Streams si es posible
	public Collection<Video> searchVideos(FiltroVideo filtro) {
		HashSet<Video> set = new HashSet<Video>();
		for (Video video : videos.values()) {
			if (filtro.esVideoOK(video)) {
				set.add(video);
			}
		}
		return set;
	}

	public Collection<Video> searchVideos(List<Etiqueta> etiquetas) {
		HashSet<Video> set = new HashSet<Video>();
		int contador = 0;
		for (Video video : videos.values()) {
			contador = video.checkEtiqueta(etiquetas);
			if (contador == etiquetas.size()) {
				set.add(video);
			}
		}
		return set;
	}

	/* Recupera todos los videos para trabajar con ellos en memoria */
	private void cargarCatalogo() throws DAOException {
		List<Video> videosBD = adaptadorVideo.recuperarVideos();
		for (Video v : videosBD) {
			videos.put(v.getUrl(), v);
		}

	}

}
