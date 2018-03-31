package sistema.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.SelectEvent;

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
	public void abrirOpcoesCampeonato() {
	
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        //System.out.println("chegou aqui");
        PrimeFaces.current().dialog().openDynamic("cadastroCategoria", options, null);
    }
	public void retornoOpcoesCampeonato(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }
}
