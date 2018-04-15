package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DragDropEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Equipe;
import sistema.modelos.Inscricao;
import sistema.modelos.Local;
import sistema.modelos.Usuario;
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
	public void onDiretorDrop(DragDropEvent ddEvent) {
		Equipe equipe= (Equipe) ddEvent.getComponent().getAttributes().get("equipe");
		Usuario diretor = ((Usuario) ddEvent.getData());
		System.out.println(diretor);
		if(equipe.getDiretores()==null)
			equipe.setDiretores(new ArrayList<Usuario>());
		for (Usuario user : equipe.getDiretores())
			if(diretor == user)
				return;
		equipe.getDiretores().add(diretor);
    }
}
	