package um.tds.AppVideo.dominio;

import java.util.HashMap;
import java.util.Map;

public class RepositorioUsuario {
	Map<String, Usuario> usuarios;

	private static RepositorioUsuario unicaInstancia = new RepositorioUsuario();

	public static RepositorioUsuario getUnicaInstancia() {
		return unicaInstancia;
	}

	public RepositorioUsuario() {
		this.usuarios = new HashMap<String, Usuario>();

	}

	public Usuario findUsuario(String usuario) {
		return usuarios.get(usuario);
	}

	public void addUsuario(Usuario usuario) {
		if (usuario != null)
			usuarios.put(usuario.getUsuario(), usuario);
	}

}
