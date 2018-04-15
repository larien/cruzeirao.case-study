package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import enumeration.EnumJuizTipo;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Juiz;
import sistema.service.JuizService;

@ManagedBean(eager=true)
@ApplicationScoped
public class JuizMB {
	private JuizService service;
	private Juiz juiz;
	private static Campeonato camp;

	@PostConstruct
    public void init() {
		service = new JuizService();
		juiz = new Juiz();
    }
	public void salvar()
	{
		service.salvar(juiz);
		juiz = new Juiz();
	}
	
	public Juiz getJuiz() {
		return juiz;
	}
	public void setJuiz(Juiz Juiz) {
		this.juiz = Juiz;
	}
	public void remover (Juiz Juiz)
	{
		service.remove(Juiz);
	}

	public List<Juiz> getJuizes() {
		return service.getJuizes();
	}

	public EnumJuizTipo[] getTipoJuiz(){
		System.out.println(EnumJuizTipo.values());
        return EnumJuizTipo.values();
    }
	
	@SuppressWarnings("unchecked")
	public void editarJuiz(ActionEvent event)
	{
		camp = (Campeonato)event.getComponent().getAttributes().get("campeonato");
		if (camp.getJuizes()==null)
			camp.setJuizes(new ArrayList<Juiz>());
		service.setJuizes(camp.getJuizes());
		
	}
	private void setJuizes(List<Juiz> lista) {
		service.setJuizes(lista);
	}
}