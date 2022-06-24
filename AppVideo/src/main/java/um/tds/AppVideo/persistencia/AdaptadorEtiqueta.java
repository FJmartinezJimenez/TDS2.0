package um.tds.AppVideo.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.AppVideo.dominio.Etiqueta;

public class AdaptadorEtiqueta implements IAdaptadorEtiquetaDAO {
	private ServicioPersistencia servPersistencia; 

	public static AdaptadorEtiqueta unicaInstancia = null;
	
	public static AdaptadorEtiqueta getUnicaInstancia() {
		if (unicaInstancia == null) {
			 unicaInstancia = new AdaptadorEtiqueta();
		}
			return unicaInstancia;
	}
	
	public AdaptadorEtiqueta() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}


	@Override
	public void addEtiqueta(Etiqueta etiqueta) {
		//Comprobamos que no esta registrada la entidad
		Entidad eEtiqueta = null;
		try{
			eEtiqueta = servPersistencia.recuperarEntidad(etiqueta.getId());
		} catch (NullPointerException e) {};
		if (eEtiqueta!=null) {return;}
		//Una vez comprobado, creamos la entidad
		eEtiqueta = new Entidad();
		eEtiqueta.setNombre("etiqueta");
		//Añadimos las propiedades
		eEtiqueta.setPropiedades(
						 new ArrayList<Propiedad>(Arrays.asList(
								 new Propiedad("nombre",etiqueta.getNombre()))
								 ));
		//Registramos la entidad y asignamos un id
		eEtiqueta = servPersistencia.registrarEntidad(eEtiqueta);
		etiqueta.setId(eEtiqueta.getId());
		}

	@Override
	public void removeEtiqueta(Etiqueta etiqueta) {
		//Recuperamos la entidad
		Entidad e = servPersistencia.recuperarEntidad(etiqueta.getId());
		if (e == null) {return;}
		//Borramos la entidad
		servPersistencia.borrarEntidad(e);
	}

	@Override
	public Etiqueta findEtiqueta(int codigo) {
		 Entidad entidad = servPersistencia.recuperarEntidad(codigo);
		 if (entidad == null) {
				return null;
		 }else {
			String nombre = servPersistencia.recuperarPropiedadEntidad(entidad, "nombre");
			Etiqueta etiqueta = new Etiqueta(nombre);
			etiqueta.setId(entidad.getId());
			return etiqueta;
			}

	}

	@Override
	public List<Etiqueta> recuperarEtiqueta() {
		List<Etiqueta> etiquetas = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades("etiqueta");
		for (Entidad e : ent) {
			e = servPersistencia.recuperarEntidad(e.getId());
			if (e == null)
				return null;
			String nombre = servPersistencia.recuperarPropiedadEntidad(e, "nombre");
			Etiqueta etiqueta = new Etiqueta(nombre);
			etiqueta.setId(e.getId());
			etiquetas.add(etiqueta);
		}

		return etiquetas;
	}


	
}

