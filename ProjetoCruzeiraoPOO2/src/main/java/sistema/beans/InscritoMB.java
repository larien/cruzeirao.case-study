package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Inscrito;
import sistema.service.InscritoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class InscritoMB {
	private InscritoService service = new InscritoService();
	private Inscrito Inscrito = new Inscrito();

	public void salvar()
	{
		service.salvar(Inscrito);
		Inscrito = new Inscrito();
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
	