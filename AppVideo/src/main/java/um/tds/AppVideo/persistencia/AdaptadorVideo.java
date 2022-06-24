package um.tds.AppVideo.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.AppVideo.dominio.Etiqueta;
import um.tds.AppVideo.dominio.Video;

public class AdaptadorVideo implements IAdaptadorVideoDAO {
	private ServicioPersistencia servPersistencia;

	private static AdaptadorVideo unicaInstancia = null;

	public static AdaptadorVideo getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AdaptadorVideo();
		}
		return unicaInstancia;
	}

	public AdaptadorVideo() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	@Override
	public void addVideo(Video video) {
		// Comprobamos que no esta registrada la entidad
		Entidad eVideo = null;
		try {
			eVideo = servPersistencia.recuperarEntidad(video.getId());
		} catch (NullPointerException e) {
		}
		;
		if (eVideo != null) {
			return;
		}
		// Una vez comprobado, creamos la entidad
		eVideo = new Entidad();
		eVideo.setNombre("video");

		// Añadimos las propiedades
		eVideo.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("titulo", video.getTitulo()),
				new Propiedad("num_repro", Integer.toString(video.getNumRepro())), new Propiedad("url", video.getUrl()),
				new Propiedad("etiqueta", this.getIdEtiquetas(video.getEtiquetas())))));

		// Registramos la entidad y asignamos un id
		eVideo = servPersistencia.registrarEntidad(eVideo);
		video.setId(eVideo.getId());
	}

	private String getIdEtiquetas(List<Etiqueta> etiquetas) {
		String aux = "";
		for (Etiqueta e : etiquetas) {
			aux += e.getId() + " ";
		}
		return aux.trim();
	}

	private List<Etiqueta> obtenerEtiquetasDesdeCodigos(String etiquetas) {
		List<Etiqueta> et = new ArrayList<>();
		StringTokenizer strTok = new StringTokenizer(etiquetas, " ");
		AdaptadorEtiqueta adaptadorEtiquetas = AdaptadorEtiqueta.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			et.add(adaptadorEtiquetas.findEtiqueta(Integer.valueOf((String) strTok.nextElement())));
		}
		return et;

	}

	@Override
	public void removeVideo(Video video) {
		// Recuperamos la entidad
		Entidad e = servPersistencia.recuperarEntidad(video.getId());
		if (e == null) {
			return;
		}
		// Borramos la entidad
		servPersistencia.borrarEntidad(e);
	}

	@Override
	public void modifyVideo(Video video) {
		// Recuperamos la entidad
		Entidad e = servPersistencia.recuperarEntidad(video.getId());
		// Recorremos las propiedades y las actualizamos
		for (Propiedad prop : e.getPropiedades()) {
			if (prop.getNombre().equals("titulo")) {
				prop.setValor(video.getTitulo());
			} else if (prop.getNombre().equals("num_repro")) {
				prop.setValor(String.valueOf(video.getNumRepro()));
			} else if (prop.getNombre().equals("etiqueta")) {
				prop.setValor(String.valueOf(getIdEtiquetas(video.getEtiquetas())));
			}
			servPersistencia.modificarPropiedad(prop);
		}

	}

	@Override
	public Video findVideo(int codigo) {
		Entidad e = servPersistencia.recuperarEntidad(codigo);
		if (e == null)
			return null;
		String titulo = servPersistencia.recuperarPropiedadEntidad(e, "titulo");
		String url = servPersistencia.recuperarPropiedadEntidad(e, "url");
		String numrepro = servPersistencia.recuperarPropiedadEntidad(e, "num_repro");
		String etiquetas = servPersistencia.recuperarPropiedadEntidad(e, "etiqueta");
		Video v = new Video(url, titulo, null);
		v.setNumRepro(Integer.parseInt(numrepro));
		v.setId(e.getId());
		v.setEtiquetas(obtenerEtiquetasDesdeCodigos(etiquetas));
		return v;

	}

	@Override
	public List<Video> recuperarVideos() {
		List<Video> videos = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades("video");
		for (Entidad e : ent) {
			e = servPersistencia.recuperarEntidad(e.getId());
			if (e == null)
				return null;
			String titulo = servPersistencia.recuperarPropiedadEntidad(e, "titulo");
			String url = servPersistencia.recuperarPropiedadEntidad(e, "url");
			String numrepro = servPersistencia.recuperarPropiedadEntidad(e, "num_repro");
			String etiquetas = servPersistencia.recuperarPropiedadEntidad(e, "etiqueta");
			Video video = new Video(url, titulo, null);
			video.setNumRepro(Integer.parseInt(numrepro));
			video.setId(e.getId());
			video.setEtiquetas(obtenerEtiquetasDesdeCodigos(etiquetas));
			videos.add(video);
		}
		return videos;
	}

}

