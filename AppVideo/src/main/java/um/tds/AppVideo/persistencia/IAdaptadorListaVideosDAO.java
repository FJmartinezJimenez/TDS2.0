package um.tds.AppVideo.persistencia;

import java.util.List;

import um.tds.AppVideo.dominio.ListaVideos;

public interface IAdaptadorListaVideosDAO {
	
	public void addListaVideos(ListaVideos lista);

	public void removeListaVideo(ListaVideos lista);

	public void modifyListaVideo(ListaVideos lista);

	public ListaVideos findListaVideo(int codigo);

	public List<ListaVideos> recuperarListaVideos();


}
