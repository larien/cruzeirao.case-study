package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Equipe;
import sistema.modelos.Inscricao;
import sistema.service.EquipeService;

@ManagedBean(eager=true)
@ApplicationScoped
public class EquipeMB {
	private EquipeService service = new EquipeService();
	private Equipe Equipe = new Equipe();

	@PostConstruct
    public void init() {
		service = new EquipeService();
		Equipe = new Equipe();
    }
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
	