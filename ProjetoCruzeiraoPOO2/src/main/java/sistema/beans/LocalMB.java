package sistema.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Local;
import sistema.service.LocalService;

@ManagedBean(eager=true)
@ApplicationScoped
public class LocalMB {
	private LocalService service = new LocalService();
	private Local local = new Local();
	
	@PostConstruct
    public void init() {
		service = new LocalService();
		local = new Local();
    }
	
	public void salvar()
	{
		service.salvar(local);
		local = new Local();
	}
	
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public void remover (Local local)
	{
		service.remove(local);
	}

	public List<Local> getLocais() {
		return service.getLocais();
	}
}
	