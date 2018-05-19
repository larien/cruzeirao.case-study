package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import enumeration.EnumInscritoTipo;
import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;
import sistema.service.InscritoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class InscritoMB {
	private InscritoService service;
	private Inscrito Inscrito;
	private static Inscricao insc;
	
	@PostConstruct
    public void init() {
		service = new InscritoService();
		Inscrito = new Inscrito();
    }
	
	public void salvar()
	{
		service.salvar(Inscrito);
		Inscrito = new Inscrito();
	}

	public void editarInscrito(ActionEvent event)
	{
		insc = (Inscricao)event.getComponent().getAttributes().get("inscricao");
		if(insc.getInscritos()==null)
			insc.setInscritos(new ArrayList<Inscrito>());	
		//service.setInscritos(insc.getInscritos());
		Inscrito.setInscricao(insc);
	}
	
	
	public Inscrito getInscrito() {
		return Inscrito;
	}
	public void setInscrito(Inscrito Inscrito) {
		this.Inscrito = Inscrito;
	}
	public void remover (Inscrito Inscrito)
	{
		service.remove(Inscrito);
	}

	public List<Inscrito> getInscritos() {
		return service.getInscritos();
	}

	public EnumInscritoTipo[] getTipoInscrito(){
        return EnumInscritoTipo.values();
    }
	
}
