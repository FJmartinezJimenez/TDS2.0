package um.tds.AppVideo.persistencia;

import java.util.List;

import um.tds.AppVideo.dominio.Usuario;

public interface IAdaptadorUsuarioDAO {

	public void addUsuario(Usuario usuario);

	public void removeUsuario(Usuario usuario);

	public void modifyUsuario(Usuario usuario);

	public Usuario findUsuario(int codigo);

	public List<Usuario> recuperarUsuarios();

}
