package um.tds.AppVideo.dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import um.tds.AppVideo.persistencia.DAOException;
import um.tds.AppVideo.persistencia.FactoriaDAO;
import um.tds.AppVideo.persistencia.IAdaptadorUsuarioDAO;

public class RepositorioUsuario {
	Map<String, Usuario> usuarios;

	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	private static RepositorioUsuario unicaInstancia = new RepositorioUsuario();

	public static RepositorioUsuario getUnicaInstancia() {
		return unicaInstancia;
	}

	public RepositorioUsuario() {

		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorUsuario = dao.getUsuarioDAO();
			this.usuarios = new HashMap<String, Usuario>();
			this.cargarCatalogo();
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	// Obtenemos el usuuario
	public Usuario getUsuario(String usuario) {
		return usuarios.get(usuario);
	}

	// Añadir usuario
	public void addUsuario(Usuario usuario) {
		usuarios.put(usuario.getUsuario(), usuario);
	}

	// Borrar usuario
	public void removeUsuario(Usuario u) {
		usuarios.remove(u.getUsuario());
	}

	// Recupera todos los clientes para trabajar con ellos en memoria
	private void cargarCatalogo() throws DAOException {
		List<Usuario> usuarioBD = adaptadorUsuario.recuperarUsuarios();
		for (Usuario u : usuarioBD) {
			usuarios.put(u.getUsuario(), u);
		}
	}

}
