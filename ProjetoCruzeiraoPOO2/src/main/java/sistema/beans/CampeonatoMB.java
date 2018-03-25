package sistema.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.DragDropEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Juiz;
import sistema.modelos.Local;
import sistema.modelos.Categoria;
import sistema.service.CampeonatoService;

@ManagedBean(eager=true, name="campeonatoMB")
@ApplicationScoped
public class CampeonatoMB {
	private CampeonatoService service;
	private Campeonato campeonato;
	
	@PostConstruct
    public void init() {
		service = new CampeonatoService();
		campeonato = new Campeonato();
    }
	
	public void salvar()
	{
		service.salvar(campeonato);
		campeonato = new Campeonato();
	}
	public void remover(Campeonato campeonato) {
		service.remove(campeonato);
	} 
	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public List<Campeonato> getCampeonatos() {
		return service.getCampeonatos();
	}

	public void onJuizDrop(DragDropEvent ddEvent) {
        Juiz juiz = ((Juiz) ddEvent.getData());
        if(this.campeonato.getJuizes() == null)
        	this.campeonato.setJuizes(new ArrayList<Juiz>());
        for (Juiz j : campeonato.getJuizes())
        	if(juiz == j)
        		return;
        this.campeonato.getJuizes().add(juiz);
    }
	public void onLocalDrop(DragDropEvent ddEvent) {
		Local local = ((Local) ddEvent.getData());
		if(this.campeonato.getLocais()==null)
			this.campeonato.setLocais(new ArrayList<Local>());
		for (Local l : campeonato.getLocais())
			if(local == l)
				return;
		this.campeonato.getLocais().add(local);
    }
	public void onCategoriaDrop(DragDropEvent ddEvent) {
		Categoria categoria = ((Categoria) ddEvent.getData());
		if(this.campeonato.getCategorias()==null)
			this.campeonato.setCategorias(new ArrayList<Categoria>());
		for (Categoria c : campeonato.getCategorias())
			if(categoria == c)
				return;
		this.campeonato.getCategorias().add(categoria);
    }
}
