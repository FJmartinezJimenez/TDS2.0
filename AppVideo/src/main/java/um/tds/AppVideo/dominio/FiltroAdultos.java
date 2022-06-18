package um.tds.AppVideo.dominio;

public class FiltroAdultos extends FiltroVideo {

	@Override
	public boolean esVideoOK(Video video) {
		return video.getEtiquetas().stream()
								   .noneMatch(e->e.getNombre().equals("Adulto"));
	}

}
