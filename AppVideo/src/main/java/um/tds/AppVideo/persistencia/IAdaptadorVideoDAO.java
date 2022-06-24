package um.tds.AppVideo.persistencia;

import java.util.List;

import um.tds.AppVideo.dominio.Video;

public interface IAdaptadorVideoDAO {
	public void addVideo(Video video);

	public void removeVideo(Video video);

	public void modifyVideo(Video video);

	public Video findVideo(int codigo);

	public List<Video> recuperarVideos();


}
