package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import enumeration.EnumInscritoTipo;
import enumeration.EnumUsuarioTipo;
import sistema.modelos.Categoria;
import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;
import sistema.service.InscricaoService;
import sistema.service.InscritoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class InscritoMB {
	private InscritoService service;
	private Inscrito Inscrito;
	private static Inscricao inscricao;
	
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

	@SuppressWarnings("unchecked")
	public void editarInscrito(ActionEvent event)
	{
		inscricao = (Inscricao)event.getComponent().getAttributes().get("inscricao");
		if(inscricao.getInscritos()==null)
			inscricao.setInscritos(new ArrayList<Inscrito>());	
		service.setInscritos(inscricao.getInscritos());
		Inscrito.setInscricao(inscricao);
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
