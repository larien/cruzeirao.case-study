package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Grupo;
import sistema.service.GrupoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class GrupoMB {
	private GrupoService service = new GrupoService();
	private Grupo Grupo = new Grupo();

	public void salvar()
	{
		service.salvar(Grupo);
		Grupo = new Grupo();
	}
	
	public Grupo getGrupo() {
		return Grupo;
	}
	public void setGrupo(Grupo Grupo) {
		this.Grupo = Grupo;
	}
	public void remover (Grupo Grupo)
	{
		service.remove(Grupo);
	}

	public List<Grupo> getGrupos() {
		return service.getGrupos();
	}
}
	