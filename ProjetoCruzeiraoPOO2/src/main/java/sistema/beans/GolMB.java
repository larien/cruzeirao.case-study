package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Gol;
import sistema.service.GolService;

@ManagedBean(eager=true)
@ApplicationScoped
public class GolMB {
	private GolService service = new GolService();
	private Gol Gol = new Gol();

	public void salvar()
	{
		service.salvar(Gol);
		Gol = new Gol();
	}
	
	public Gol getGol() {
		return Gol;
	}
	public void setGol(Gol Gol) {
		this.Gol = Gol;
	}
	public void remover (Gol Gol)
	{
		service.remove(Gol);
	}

	public List<Gol> getGols() {
		return service.getGols();
	}
}
	