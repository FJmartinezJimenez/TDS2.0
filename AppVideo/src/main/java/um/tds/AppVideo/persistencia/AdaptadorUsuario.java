package um.tds.AppVideo.persistencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.AppVideo.dominio.FiltroVideo;
import um.tds.AppVideo.dominio.ListaVideos;
import um.tds.AppVideo.dominio.Usuario;
import um.tds.AppVideo.dominio.Video;

public class AdaptadorUsuario  implements IAdaptadorUsuarioDAO {
	private ServicioPersistencia servPersistencia;

	private static AdaptadorUsuario unicaInstancia = null;

	public static AdaptadorUsuario getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AdaptadorUsuario();
		}
		return unicaInstancia;
	}

	public AdaptadorUsuario() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	@Override
	public void addUsuario(Usuario usuario) {
		// Comprobamos que no esta registrada la entidad
		Entidad eUsuario = null;
		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getId());
		} catch (NullPointerException e) {}
		if (eUsuario != null) {
			return;
		}
		// Una vez comprobado, creamos la entidad
		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");

		// Añadimos las propiedades
		if (usuario.isPremium()) {
			eUsuario.setPropiedades(
				new ArrayList<Propiedad>(Arrays.asList(
				new Propiedad("nombre", usuario.getNombre()),
				new Propiedad("apellidos", usuario.getApellidos()), 
				new Propiedad("email", usuario.getEmail()),
				new Propiedad("usuario", usuario.getUsuario()),
				new Propiedad("password", usuario.getPassword()),
				new Propiedad("fecha_nac", usuario.getFechaNacimiento().toString()),
				new Propiedad("filtro", usuario.getFiltro().toString()),
				new Propiedad("listas",getIdListas(usuario.getListasVideos())),
				new Propiedad("recientes", getIdRecientes(usuario.getRecientes())),
				new Propiedad("premium", "T"))
				));
		}else {
			eUsuario.setPropiedades(
					new ArrayList<Propiedad>(Arrays.asList(
					new Propiedad("nombre", usuario.getNombre()),
					new Propiedad("apellidos", usuario.getApellidos()), 
					new Propiedad("email", usuario.getEmail()),
					new Propiedad("usuario", usuario.getUsuario()),
					new Propiedad("password", usuario.getPassword()),
					new Propiedad("fecha_nac", usuario.getFechaNacimiento().toString()),
					new Propiedad("filtro", usuario.getFiltro().toString()),
					new Propiedad("listas",getIdListas(usuario.getListasVideos())),
					new Propiedad("recientes", getIdRecientes(usuario.getRecientes())),
					new Propiedad("premium", "F"))
					));
		}
			
		// Registramos la entidad y asignamos un id
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		usuario.setId(eUsuario.getId());
	}

	private String getIdRecientes(List<Video> recientes) {
		String aux = "";
		for (Video video : recientes) {
			aux += video.getId() + " ";
		}
		return aux.trim();
	}


	public String getIdListas(List<ListaVideos> listavideos) {
		String aux = "";
		for (ListaVideos lista : listavideos) {
			aux += lista.getId() + " ";
		}
		return aux.trim();
}


	@Override
	public void removeUsuario(Usuario usuario) {
		//Recuperamos la entidad
		Entidad e = servPersistencia.recuperarEntidad(usuario.getId());
		if (e == null)
			return;
		//Borramos todas las listas asoaciadas a la entidad Usuario
		try {
			IAdaptadorListaVideosDAO adaptadorlistaVideo = FactoriaDAO.getInstancia().getListaVideosDAO();
			for (ListaVideos l : usuario.getListasVideos()) {
				adaptadorlistaVideo.removeListaVideo(l);
			}
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		//Borramos la entidad
		servPersistencia.borrarEntidad(e);
	}

	@Override
	public void modifyUsuario(Usuario usuario) {
		//Recuperamos la entidad
		Entidad e = servPersistencia.recuperarEntidad(usuario.getId());
		//Recorremos las propiedades y las actualizamos
		for (Propiedad prop : e.getPropiedades()) {
			if (prop.getNombre().equals("nombre")) {
				prop.setValor(usuario.getNombre());
			}else if (prop.getNombre().equals("apellidos")) {
				prop.setValor(usuario.getApellidos());
			}else if (prop.getNombre().equals("email")) {
				prop.setValor(usuario.getEmail());
			}else if (prop.getNombre().equals("usuario")) {
				prop.setValor(usuario.getUsuario());
			}else if (prop.getNombre().equals("password")) {
				prop.setValor(usuario.getPassword());
			}else if (prop.getNombre().equals("fecha_nac")) {
				prop.setValor(usuario.getFechaNacimiento().toString());
			}else if (prop.getNombre().equals("filtro")) {
				prop.setValor(usuario.getFiltro().toString());
			}else if (prop.getNombre().equals("listas")) {
				prop.setValor(getIdListas(usuario.getListasVideos()));
			}else if (prop.getNombre().equals("recientes")) {
				prop.setValor(getIdRecientes(usuario.getRecientes()));
			}else if (prop.getNombre().equals("premium")) {
				if(usuario.isPremium()) {
					prop.setValor("T");
				}else {
					prop.setValor("F");
				}
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	@Override
	public Usuario findUsuario(int codigo) {
		Entidad e = servPersistencia.recuperarEntidad(codigo);
		if (e == null)
			return null;
		String nombre = servPersistencia.recuperarPropiedadEntidad(e, "nombre");
		String apellidos = servPersistencia.recuperarPropiedadEntidad(e, "apellidos");
		String email = servPersistencia.recuperarPropiedadEntidad(e, "email");
		String user = servPersistencia.recuperarPropiedadEntidad(e, "usuario");
		String password = servPersistencia.recuperarPropiedadEntidad(e, "password");
		String fechaNacimiento = servPersistencia.recuperarPropiedadEntidad(e, "fecha_nac");
		String filtro = servPersistencia.recuperarPropiedadEntidad(e, "filtro");
		String premium = servPersistencia.recuperarPropiedadEntidad(e, "premium");
		boolean prem = false;
		if (premium.equals("T"))
			prem = true;
		else
			prem = false;
		
		FiltroVideo f = null;
		try {
			f = (FiltroVideo) Class.forName(filtro).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		LocalDate d = null;
		if (fechaNacimiento != null)
			d = LocalDate.parse(fechaNacimiento);
		Usuario u = new Usuario(nombre, apellidos, email, user, password, d, prem);
		u.setId(e.getId());
		u.setListasVideos(ObtenerListasDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(e, "listas")));
		u.setRecientes(ObtenerVideosDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(e, "reciente")));
		u.setFiltro(f);
		return u;
	}
	
	@Override
	public List<Usuario> recuperarUsuarios() {

		List<Usuario> users = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades("Usuario");
		for (Entidad e : ent) {
			// servPersistencia.borrarEntidad(e);
			Entidad eaux = servPersistencia.recuperarEntidad(e.getId());
			users.add(buildUsuario(eaux));

		}

		return users;

	}

	private Usuario buildUsuario(Entidad e) {
		if (e == null)
			return null;

		String nombre = servPersistencia.recuperarPropiedadEntidad(e, "nombre");
		String apellidos = servPersistencia.recuperarPropiedadEntidad(e, "apellidos");
		String email = servPersistencia.recuperarPropiedadEntidad(e, "email");
		String user = servPersistencia.recuperarPropiedadEntidad(e, "usuario");
		String password = servPersistencia.recuperarPropiedadEntidad(e, "password");
		String fechaNacimiento = servPersistencia.recuperarPropiedadEntidad(e, "fecha_nac");
		String premium = servPersistencia.recuperarPropiedadEntidad(e, "premium");

		String filtro = servPersistencia.recuperarPropiedadEntidad(e, "filtro");
		FiltroVideo f = null;

		try {
			f = (FiltroVideo) Class.forName(filtro).newInstance();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		if (f == null) {

			System.out.println("filtro nulo cuidado");
		}

		boolean prem = false;

		if (premium.equals("T"))
			prem = true;
		else
			prem = false;

		LocalDate d = null;

		if (fechaNacimiento != null)
			d = LocalDate.parse(fechaNacimiento);
		Usuario u = new Usuario(nombre, apellidos, email, user, password, d,prem);

		u.setId(e.getId());

		u.setListasVideos(ObtenerListasDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(e, "listas")));

		u.setRecientes(ObtenerVideosDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(e, "recientes")));

		u.setFiltro(f);

		return u;

	}	

	private LinkedList<Video> ObtenerVideosDesdeCodigos(String videos) {
		LinkedList<Video> listaRecientes = new LinkedList<Video>();
		if(videos != null) {
			StringTokenizer strTok = new StringTokenizer(videos, " ");
			AdaptadorVideo adaptadorV = AdaptadorVideo.getUnicaInstancia();
			while (strTok.hasMoreTokens()) {
				listaRecientes.add(adaptadorV.findVideo(Integer.valueOf((String) strTok.nextElement())));
			}
		}
		return listaRecientes;
	}

	private List<ListaVideos> ObtenerListasDesdeCodigos(String lista) {
		List<ListaVideos> listaVideo = new LinkedList<ListaVideos>();
		if(lista != null) {
			StringTokenizer strTok = new StringTokenizer(lista, " ");
			AdaptadorListaVideos adaptadorV = AdaptadorListaVideos.getUnicaInstancia();
			while (strTok.hasMoreTokens()) {
				listaVideo.add(adaptadorV.findListaVideo(Integer.valueOf((String) strTok.nextElement())));
			}
		}
		return listaVideo;

	}


}

