package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.PartidaFutebol;
import sistema.service.PartidaFutebolService;

@ManagedBean(eager=true)
@ApplicationScoped
public class PartidaFutebolMB {
	private PartidaFutebolService service = new PartidaFutebolService();
	private PartidaFutebol PartidaFutebol = new PartidaFutebol();

	public void salvar()
	{
		service.salvar(PartidaFutebol);
		PartidaFutebol = new PartidaFutebol();
	}
	
	public PartidaFutebol getPartidaFutebol() {
		return PartidaFutebol;
	}
	public void setPartidaFutebol(PartidaFutebol PartidaFutebol) {
	}
	public void remover (PartidaFutebol PartidaFutebol)
	{
		service.remove(PartidaFutebol);
	}

	public List<PartidaFutebol> getPartidasFutebol() {
		return service.getPartidasFutebol();
	}
}
	