package um.tds.AppVideo.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.AppVideo.dominio.ListaVideos;
import um.tds.AppVideo.dominio.Video;

public class AdaptadorListaVideos implements IAdaptadorListaVideosDAO {
	private ServicioPersistencia servPersistencia;

	private static AdaptadorListaVideos unicaInstancia = null;

	public static AdaptadorListaVideos getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AdaptadorListaVideos();
		}
		return unicaInstancia;
	}

	public AdaptadorListaVideos() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	@Override
	public void addListaVideos(ListaVideos lista) {
		// Comprobamos que no esta registrada la entidad
		Entidad eLista = null;
		try {
			eLista = servPersistencia.recuperarEntidad(lista.getId());
		} catch (NullPointerException e) {
		}
		;
		if (eLista != null) {
			return;
		}
		// Una vez comprobado, creamos la entidad
		eLista = new Entidad();
		eLista.setNombre("lista");
		// Añadimos las propiedades
		eLista.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", lista.getName()),
				new Propiedad("videos", getIdVideos(lista.getVideos())))));
		// Registramos la entidad y asignamos un id
		eLista = servPersistencia.registrarEntidad(eLista);
		lista.setId(eLista.getId());
	}

	public String getIdVideos(List<Video> videos) {
		String aux = "";
		for (Video v : videos) {
			aux += v.getId() + " ";
		}
		return aux.trim();
	}

	private List<Video> ObtenerCodigoDesdeVideo(String videos) {
		List<Video> v = new ArrayList<>();
		StringTokenizer strTok = new StringTokenizer(videos, " ");
		AdaptadorVideo adaptadorVideo = AdaptadorVideo.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			v.add(adaptadorVideo.findVideo(Integer.valueOf((String) strTok.nextElement())));
		}
		return v;
	}

	@Override
	public void removeListaVideo(ListaVideos lista) {
		// Recuperamos la entidad
		Entidad e = servPersistencia.recuperarEntidad(lista.getId());
		if (e == null) {
			return;
		}
		// Borramos la entidad
		servPersistencia.borrarEntidad(e);
	}

	@Override
	public void modifyListaVideo(ListaVideos lista) {
		// Recuperamos la entidad
		Entidad e = servPersistencia.recuperarEntidad(lista.getId());
		// Recorremos las propiedades y las actualizamos
		for (Propiedad prop : e.getPropiedades()) {
			if (prop.getNombre().equals("nombre")) {
				prop.setValor(lista.getName());
			} else if (prop.getNombre().equals("videos")) {
				prop.setValor(getIdVideos(lista.getVideos()));
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	@Override
	public ListaVideos findListaVideo(int codigo) {
		Entidad e = servPersistencia.recuperarEntidad(codigo);
		if (e == null)
			return null;
		String nombre = servPersistencia.recuperarPropiedadEntidad(e, "nombre");
		ListaVideos l = new ListaVideos(nombre, null);
		l.setId(e.getId());
		l.setVideos(ObtenerCodigoDesdeVideo(servPersistencia.recuperarPropiedadEntidad(e, "videos")));

		return l;

	}

	@Override
	public List<ListaVideos> recuperarListaVideos() {
		List<ListaVideos> listas = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades("lista");
		for (Entidad e : ent) {
			e = servPersistencia.recuperarEntidad(e.getId());
			if (e == null)
				return null;
			String nombre = servPersistencia.recuperarPropiedadEntidad(e, "nombre");
			ListaVideos l = new ListaVideos(nombre, null);
			l.setId(e.getId());
			l.setVideos(ObtenerCodigoDesdeVideo(servPersistencia.recuperarPropiedadEntidad(e, "videos")));
			listas.add(l);
		}
		return listas;
	}

}

