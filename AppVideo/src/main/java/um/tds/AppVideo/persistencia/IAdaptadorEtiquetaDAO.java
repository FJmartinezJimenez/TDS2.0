package um.tds.AppVideo.persistencia;

import java.util.List;

import um.tds.AppVideo.dominio.Etiqueta;

public interface IAdaptadorEtiquetaDAO {
	
	public void addEtiqueta(Etiqueta etiqueta);

	public void removeEtiqueta(Etiqueta etiqueta);

	public Etiqueta findEtiqueta(int codigo);

	public List<Etiqueta> recuperarEtiqueta();

}
