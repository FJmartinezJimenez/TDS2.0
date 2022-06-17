package um.tds.AppVideo.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.AppVideo.dominio.Usuario;

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
					new Propiedad("premium", "F"))
					));
		}
			
		// Registramos la entidad y asignamos un id
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		usuario.setId(eUsuario.getId());
	}

	public void removeUsuario(Usuario usuario) {
		// TODO Apéndice de método generado automáticamente
		
	}

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

	public Usuario findUsuario(int codigo) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	public List<Usuario> recuperarUsuarios() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}
