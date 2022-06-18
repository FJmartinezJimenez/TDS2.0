package um.tds.AppVideo.dominio;

import um.tds.AppVideo.controlador.Controlador;

public class FiltroMisListas extends FiltroVideo {

	@Override
	public boolean esVideoOK(Video video) {
		return Controlador.getUnicaInstancia().getListas().stream()
														  .flatMap(l -> l.getVideos().stream())
														  .anyMatch(v -> v.getTitulo().equals(video.getTitulo()));

	}

}