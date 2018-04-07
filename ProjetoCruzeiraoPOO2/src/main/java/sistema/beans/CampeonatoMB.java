package sistema.beans;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;

//import org.primefaces.PrimeFaces;
import org.primefaces.event.DragDropEvent;
//import org.primefaces.event.SelectEvent;
import org.primefaces.event.FlowEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Juiz;
import sistema.modelos.Local;
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
		//System.out.println(campeonato);
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
		Campeonato teste= (Campeonato) ddEvent.getComponent().getAttributes().get("campeonato");
		Local local = ((Local) ddEvent.getData());
		
		if(teste.getLocais()==null)
			teste.setLocais(new ArrayList<Local>());
		for (Local l : teste.getLocais())
			if(local == l)
				return;
		teste.getLocais().add(local);
    }
}
