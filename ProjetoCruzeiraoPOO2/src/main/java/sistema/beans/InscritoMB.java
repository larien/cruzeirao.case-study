package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import sistema.modelos.Categoria;
import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;
import sistema.service.InscritoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class InscritoMB {
	private InscritoService service = new InscritoService();
	private Inscrito Inscrito = new Inscrito();
	private static Inscricao inscricao;
	public void salvar()
	{
		inscricao.getInscritos().add(Inscrito);
		Inscrito = new Inscrito();
	}

	@SuppressWarnings("unchecked")
	public void editarInscrito(ActionEvent event)
	{
		ArrayList<Inscrito> lista = (ArrayList<Inscrito>)event.getComponent().getAttributes().get("inscrito");
		inscricao = (Inscricao)event.getComponent().getAttributes().get("inscricao");
		if((ArrayList<sistema.modelos.Inscrito>) inscricao.getInscritos()==null)
			service.setInscritos(new ArrayList<sistema.modelos.Inscrito>());	
		else
			service.setInscritos((ArrayList<sistema.modelos.Inscrito>) inscricao.getInscritos());
		System.out.println(inscricao);
		System.out.println(service.getInscritos());
		
		if( service.getInscritos()==null)
				service.setInscritos(new ArrayList<Inscrito>());
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
}
