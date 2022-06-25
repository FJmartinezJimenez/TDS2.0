package um.tds.AppVideo.dominio;

public class NoFiltro extends FiltroVideo {

	@Override
	public boolean esVideoOK(Video video) {
		return true;
	}

}
