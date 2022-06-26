package um.tds.AppVideo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import um.tds.AppVideo.controlador.Controlador;
import um.tds.AppVideo.dominio.RepositorioUsuario;
import um.tds.AppVideo.dominio.Usuario;

public class RepositorioUsuarioTest extends TestCase {
	public static RepositorioUsuario repositorio;
	public static LinkedList<Usuario> usuarios;
	public static Controlador controlador;

	@BeforeClass
	public static void setUpBefore() {
		repositorio = RepositorioUsuario.getUnicaInstancia();
		controlador = Controlador.getUnicaInstancia();
		for (Usuario u : repositorio.getUsuarios()) {
			repositorio.removeUsuario(u);
		}
		usuarios = new LinkedList<Usuario>();
		Usuario u1 = new Usuario("Fran","Martinez","mar@gmail.com","franmar","hola",LocalDate.of(2020,1,8),false);
		usuarios.add(u1);
		
		Usuario u2 = new Usuario("Josema","Montalban","mon@gmail.com","jomon","adios",LocalDate.of(2020,2,8),true);
		usuarios.add(u2);

	}

	// Test de insertar usuarios
	@Before
	public void testInsertar() {
		for (Usuario u : usuarios) {
			repositorio.addUsuario(u);
		}
		Collection<Usuario> copia = repositorio.getUsuarios();
		for (Usuario u : usuarios) {
			assertTrue(copia.contains(u));

		}

	}

	// Test de borrado de usuario
	@Test
	public void testRemoveUsuario() {
		for (Usuario u : usuarios) {
			repositorio.removeUsuario(u);
		}
		Collection<Usuario> copia = repositorio.getUsuarios();
		for (Usuario u : usuarios) {
			assertFalse(copia.contains(u));
		}

	}

}
