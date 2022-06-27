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

	// Obtenemos todos los videos
	public List<Video> getVideos() {
		ArrayList<Video> lista = new ArrayList<Video>();
		for (Video v : videos.values()) {
			lista.add(v);
		}
		return lista;
	}

	// Obtenemos el video
	public Video getVideo(String video) {
		return videos.get(video);
	}

	// Añadimos un video
	public void addVideo(Video video) {
		videos.put(video.getUrl(), video);
	}

	// Borrar video
	public void removeVideo(Video video) {
		videos.remove(video.getUrl());
	}

	// Añadimos un video
	public void addEtiqueta(Video video, Etiqueta etiqueta) {
		video.addEtiqueta(etiqueta);
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

	public Collection<Video> searchVideos(List<String> etiquetas) {
		HashSet<Video> set = new HashSet<Video>();
		int control = 0;

		for (Video v : videos.values()) {

			for (Etiqueta et : v.getEtiquetas()) {

				for (String et2 : etiquetas) {

					if (et2.equals(et.getNombre())) {

						control += 1;
					}

				}
			}

			if (etiquetas.size() == control) {

				set.add(v);

			}
			control = 0;
		}

		return set;

	}


	public Collection<Video> searchVideos(String titulo) {
		HashSet<Video> set = new HashSet<Video>();
		for (Video v : videos.values()) {
			if (v.getTitulo().contains(titulo)) {
				set.add(v);
			}
		}
		return set;

	}

	public Collection<Video> searchVideos(FiltroVideo filtro, String titulo, List<String> etiqueta) {
		Collection<Video> set = searchVideos(filtro);
		if (titulo != null) {
			set.retainAll(searchVideos(titulo));
		}
		if (etiqueta != null) {
			set.retainAll(searchVideos(etiqueta));
		}

		return set;

	}

	Comparator<Video> compareByNumRepro = new Comparator<Video>() {
		@Override
		public int compare(Video o1, Video o2) {
			Integer v1 = o1.getNumRepro();
			Integer v2 = o2.getNumRepro();
			return v1.compareTo(v2);

		}

	};

	public List<Video> getTop_TenVideos() {
		ArrayList<Video> lista = new ArrayList<Video>();
		for (Video video : videos.values()) {
			lista.add(video);
		}
		
		lista.sort(compareByNumRepro);
		if(lista.size()>10) {
			return lista.subList(0, 10);
		}else {
			return lista;
		}
	}

	/* Recupera todos los videos para trabajar con ellos en memoria */
	private void cargarCatalogo() throws DAOException {
		List<Video> videosBD = adaptadorVideo.recuperarVideos();
		for (Video v : videosBD) {
			videos.put(v.getUrl(), v);
		}

	}
}
