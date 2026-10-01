package repasoJava.dia1.repositories;

import java.util.ArrayList;
import java.util.List;

import repasoJava.dia1.models.Evento;

public class EventosRepository {
	private List<Evento> listaEvento;

	public EventosRepository() {
		super();
		this.listaEvento= new ArrayList<Evento>();
	}

	public List<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}
	
}
