package um.tds.AppVideo.dominio;

public class FiltroImpopulares extends FiltroVideo {

	@Override
	public boolean esVideoOK(Video video) {
		if (video.getNumRepro() < 5) {
			return false;
		} else {
			return true;
		}
	}

}