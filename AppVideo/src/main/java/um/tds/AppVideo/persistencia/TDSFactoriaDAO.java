package um.tds.AppVideo.persistencia;

public class TDSFactoriaDAO extends FactoriaDAO {

	// instancia concreta para el servidor de persistencia

	public TDSFactoriaDAO() {

	}

	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return AdaptadorUsuario.getUnicaInstancia();

	}

	@Override
	public IAdaptadorVideoDAO getVideoDAO() {
		return AdaptadorVideo.getUnicaInstancia();
	}
	
	@Override
	public IAdaptadorEtiquetaDAO getEtiquetaDAO() {
		return AdaptadorEtiqueta.getUnicaInstancia();
	}
	
	@Override
	public IAdaptadorListaVideosDAO getListaVideosDAO() {
		return AdaptadorListaVideos.getUnicaInstancia();
	}

}
