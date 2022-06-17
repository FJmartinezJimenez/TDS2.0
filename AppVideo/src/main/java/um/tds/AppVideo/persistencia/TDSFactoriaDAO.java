package um.tds.AppVideo.persistencia;

public class TDSFactoriaDAO extends FactoriaDAO {

	// instancia concreta para el servidor de persistencia

	public TDSFactoriaDAO() {

	}

	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return AdaptadorUsuario.getUnicaInstancia();

	}

}
