package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Rodada;
import sistema.service.RodadaService;

@ManagedBean(eager=true)
@ApplicationScoped
public class RodadaMB {
	private RodadaService service = new RodadaService();
	private Rodada Rodada = new Rodada();

	public void salvar()
	{
		service.salvar(Rodada);
		Rodada = new Rodada();
	}
	
	public Rodada getRodada() {
		return Rodada;
	}
	public void setRodada(Rodada Rodada) {
		this.Rodada = Rodada;
	}
	public void remover (Rodada Rodada)
	{
		service.remove(Rodada);
	}

	public List<Rodada> getRodadas() {
		return service.getRodadas();
	}
}
	