package um.tds.AppVideo.dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import um.tds.AppVideo.persistencia.DAOException;
import um.tds.AppVideo.persistencia.FactoriaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorEtiquetaDAO;

public class CatalogoEtiqueta {
	private Map<String, Etiqueta> etiquetas;
	private FactoriaDAO dao;
	private IAdaptadorEtiquetaDAO adaptadorEtiquetasDAO;

	private static CatalogoEtiqueta unicaInstancia = new CatalogoEtiqueta();

	public static CatalogoEtiqueta getUnicaInstancia() {
		return unicaInstancia;
	}

	public CatalogoEtiqueta() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorEtiquetasDAO = dao.getEtiquetaDAO();
			this.etiquetas = new HashMap<String, Etiqueta>();
			this.cargarCatalogo();
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	// Obtenemos una etiqueta
	public Etiqueta getEtiqueta(String et) {
		return etiquetas.get(et);
	}

	// Añadir etiqueta
	public void addEtiqueta(Etiqueta e) {
		etiquetas.put(e.getNombre(), e);
	}

	// Borramos etiqueta
	public void removeEtiqueta(Etiqueta u) {
		etiquetas.remove(u.getNombre());
	}

	private void cargarCatalogo() {
		List<Etiqueta> etiquetasBD = adaptadorEtiquetasDAO.recuperarEtiqueta();
		for (Etiqueta etiqueta : etiquetasBD) {
			etiquetas.put(etiqueta.getNombre(), etiqueta);
		}

	}

}
