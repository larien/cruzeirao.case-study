package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Fase;
import sistema.service.FaseService;

@ManagedBean(eager=true)
@ApplicationScoped
public class FaseMB {
	private FaseService service = new FaseService();
	private Fase Fase = new Fase();

	public void salvar()
	{
		service.salvar(Fase);
		Fase = new Fase();
	}
	
	public Fase getFase() {
		return Fase;
	}
	public void setFase(Fase Fase) {
		this.Fase = Fase;
	}
	public void remover (Fase Fase)
	{
		service.remove(Fase);
	}

	public List<Fase> getFases() {
		return service.getFases();
	}
}
	