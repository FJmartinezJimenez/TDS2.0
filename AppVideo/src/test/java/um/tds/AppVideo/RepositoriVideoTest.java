package um.tds.AppVideo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import um.tds.AppVideo.controlador.Controlador;
import um.tds.AppVideo.dominio.Etiqueta;
import um.tds.AppVideo.dominio.FiltroImpopulares;
import um.tds.AppVideo.dominio.FiltroVideo;
import um.tds.AppVideo.dominio.RepositorioVideo;
import um.tds.AppVideo.dominio.Video;

public class RepositoriVideoTest {
	public static RepositorioVideo repositorio;
	public static LinkedList<Video> videos;
	public static Controlador controlador;

	@BeforeClass
	public static void setUpBefore() {
		repositorio = RepositorioVideo.getUnicaInstancia();
		controlador = Controlador.getUnicaInstancia();
		for (Video v : repositorio.getVideos()) {
			repositorio.removeVideo(v);
		}
		videos = new LinkedList<Video>();
		Etiqueta etiqueta = new Etiqueta("etiqueta");
		ArrayList<Etiqueta> a = new ArrayList<Etiqueta>();
		a.add(etiqueta);
		Video v1 = new Video("https://www.youtube.com/watch?v=rFX5bPxqvRs", "No Soy Un Superman");
		v1.setId(1);
		v1.setNumRepro(5);
		videos.addLast(v1);
		
		Video v2 = new Video("https://www.youtube.com/watch?v=Z1Vjb2LBJJA",
				"DRAGON BALL GT RAP | PORTA | VIDEO OFICIAL RESUBIDO");
		v2.setId(15);
		v2.setNumRepro(2);
		videos.addLast(v2);

		Video v3 = new Video("https://www.youtube.com/watch?v=fPO76Jlnz6c",
				"Coolio - Gangsta's Paradise (feat. L.V.) [Video Musical Oficial]");
		v3.setId(4);
		v3.setNumRepro(1);
		videos.addLast(v3);
	}

	// Test de insertar videos
	@Before
	public void testInsertar() {
		for (Video v : videos) {
			repositorio.addVideo(v);
		}
		Collection<Video> copia = repositorio.getVideos();
		for (Video v : videos) {
			assertTrue(copia.contains(v));

		}

	}

	// Test de borrado de video
	@Test
	public void testRemoveVideo() {
		for (Video v : videos) {
			repositorio.removeVideo(v);
		}
		Collection<Video> copia = repositorio.getVideos();
		for (Video v : videos) {
			assertFalse(copia.contains(v));
		}

	}

	// Test de obtencion del top 10
	@Test
	public void testGetTop10Videos() {
		assertEquals(videos, repositorio.getTop_TenVideos());
	}

	// Test para filtrar videos
	@Test
	public void testSearchVideos() {
		FiltroVideo f = new FiltroImpopulares();
		ArrayList<String> a = new ArrayList<String>();
		a.add("etiqueta");
		String titulo = "No Soy Un Superman";
		Video v = videos.getFirst();
		Collection<Video> solucion = new HashSet<Video>();
		solucion.add(v);
		assertArrayEquals(solucion.toArray(), repositorio.searchVideos(f, titulo, a).toArray());

	}

}
