package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Cadastro;
import sistema.service.CadastroService;

@ManagedBean(eager=true)
@ApplicationScoped
public class cadastroMB {
	private CadastroService service = new CadastroService();
	private Cadastro Cadastro = new Cadastro();

	public void salvar()
	{
		service.salvar(Cadastro);
		Cadastro = new Cadastro();
	}
	
	public Cadastro getCadastro() {
		return Cadastro;
	}
	public void setCadastro(Cadastro Cadastro) {
		this.Cadastro = Cadastro;
	}
	public void remover (Cadastro Cadastro)
	{
		service.remove(Cadastro);
	}

	public List<Cadastro> getCadastros() {
		return service.getCadastros();
	}
}
	