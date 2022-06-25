package um.tds.AppVideo.dominio;

import java.util.LinkedList;
import java.util.List;

public class ListaVideos {
	private int id;
	private String name;
	private List<Video> videos;

	public ListaVideos(String name) {
		this.id = 0;
		this.name = name;
		videos = new LinkedList<Video>();
	}

	public ListaVideos(String name, List<Video> videos) {
		this.name = name;
		this.videos = videos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public boolean addVideo(Video video) {

		return videos.add(video);
	}

	public boolean removeVideo(Video video) {

		return videos.remove(video);

	}

}
