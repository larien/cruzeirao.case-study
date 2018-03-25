package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Equipe;
import sistema.service.EquipeService;

@ManagedBean(eager=true)
@ApplicationScoped
public class EquipeMB {
	private EquipeService service = new EquipeService();
	private Equipe Equipe = new Equipe();

	public void salvar()
	{
		service.salvar(Equipe);
		Equipe = new Equipe();
	}
	
	public Equipe getEquipe() {
		return Equipe;
	}
	public void setEquipe(Equipe Equipe) {
		this.Equipe = Equipe;
	}
	public void remover (Equipe Equipe)
	{
		service.remove(Equipe);
	}

	public List<Equipe> getEquipes() {
		return service.getEquipes();
	}
}
	