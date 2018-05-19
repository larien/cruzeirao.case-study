package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import sistema.modelos.Categoria;
import sistema.modelos.Inscricao;
import sistema.service.InscricaoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class InscricaoMB {
	private InscricaoService service = new InscricaoService();
	private Inscricao Inscricao = new Inscricao();
	private static Categoria cat;

	@PostConstruct
    public void init() {
		service = new InscricaoService();
		Inscricao = new Inscricao();
    }
	//classe que pega a lista de categoria vindo da data tagle do campeonato
	public void salvar()
	{
		service.salvar(Inscricao);
		Inscricao = new Inscricao();
	}
	
	public void editarInscricao(ActionEvent event)
	{
		cat = (Categoria)event.getComponent().getAttributes().get("categoria");
		if(cat.getInscricoes()==null)
			cat.setInscricoes(new ArrayList<Inscricao>());
		Inscricao.setCategoria(cat);
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

	public List<Inscricao> getInscricoes() {
		return service.getInscricoes();
	}
	public void setInscricoes(ArrayList<Inscricao> incricoes)
	{
		//service.setInscricoes(incricoes);
	}
	
	
}
	