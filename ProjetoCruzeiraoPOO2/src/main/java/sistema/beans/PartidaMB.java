package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Partida;
import sistema.service.PartidaService;

@ManagedBean(eager=true)
@ApplicationScoped
public class PartidaMB {
	private PartidaService service = new PartidaService();
	private Partida Partida = new Partida();

	public void salvar()
	{
		service.salvar(Partida);
		Partida = new Partida();
	}
	
	public Partida getPartida() {
		return Partida;
	}
	public void setPartida(Partida Partida) {
		this.Partida = Partida;
	}
	public void remover (Partida Partida)
	{
		service.remove(Partida);
	}

	public List<Partida> getPartidas() {
		return service.getPartidas();
	}
}
	