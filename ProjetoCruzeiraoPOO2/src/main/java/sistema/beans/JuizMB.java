package sistema.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Juiz;
import sistema.service.JuizService;

@ManagedBean(eager=true)
@ApplicationScoped
public class JuizMB {
	private JuizService service;
	private Juiz Juiz;

	@PostConstruct
    public void init() {
		service = new JuizService();
		Juiz = new Juiz();
    }
	public void salvar()
	{
		service.salvar(Juiz);
		Juiz = new Juiz();
	}
	
	public Juiz getJuiz() {
		return Juiz;
	}
	public void setJuiz(Juiz Juiz) {
		this.Juiz = Juiz;
	}
	public void remover (Juiz Juiz)
	{
		service.remove(Juiz);
	}

	public List<Juiz> getJuizes() {
		return service.getJuizes();
	}
}
	