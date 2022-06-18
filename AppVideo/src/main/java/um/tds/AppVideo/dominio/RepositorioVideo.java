package um.tds.AppVideo.dominio;

import java.util.*;

public class RepositorioVideo {

	Map<String, Video> videos;

	private static RepositorioVideo unicaInstancia = new RepositorioVideo();

	public static RepositorioVideo getUnicaInstancia() {
		return unicaInstancia;
	}

	public RepositorioVideo() {
		this.videos = new HashMap<String, Video>();

	}

	public Video findVideo(String video) {
		return videos.get(video);
	}

	public void addUsuario(Video video) {
		if (video != null)
			videos.put(video.getUrl(), video);
	}

	// TODO Con Streams si es posible
	public Collection<Video> searchVideos(FiltroVideo filtro) {
		HashSet<Video> set = new HashSet<Video>();
		for (Video video : videos.values()) {
			if (filtro.esVideoOK(video)) {
				set.add(video);
			}
		}
		return set;
	}

	public Collection<Video> searchVideos(List<Etiqueta> etiquetas) {
		HashSet<Video> set = new HashSet<Video>();
		int contador = 0;
		for (Video video : videos.values()) {
			contador = video.checkEtiqueta(etiquetas);
			if (contador == etiquetas.size()) {
				set.add(video);
			}
		}
		return set;
	}

}
