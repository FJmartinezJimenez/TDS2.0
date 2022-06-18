package um.tds.AppVideo.dominio;

//Clase Abstracta
public abstract class FiltroVideo {

	//Metodo abstracto que se heredara en las clases hijo
	abstract public boolean esVideoOK(Video video);
}
