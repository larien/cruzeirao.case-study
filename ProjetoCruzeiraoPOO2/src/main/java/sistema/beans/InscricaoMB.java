package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Inscricao;
import sistema.service.InscricaoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class InscricaoMB {
	private InscricaoService service = new InscricaoService();
	private Inscricao Inscricao = new Inscricao();

	public void salvar()
	{
		service.salvar(Inscricao);
		Inscricao = new Inscricao();
	}
	
	public Inscricao getInscricao() {
		return Inscricao;
	}
	public void setInscricao(Inscricao Inscricao) {
		this.Inscricao = Inscricao;
	}
	public void remover (Inscricao Inscricao)
	{
		service.remove(Inscricao);
	}

	public List<Inscricao> getInscricaos() {
		return service.getInscricoes();
	}
}
	