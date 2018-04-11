package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Inscricao;
import sistema.modelos.Juiz;
import sistema.service.InscricaoService;

@ManagedBean(eager=true)
@ApplicationScoped
public class InscricaoMB {
	private InscricaoService service = new InscricaoService();
	private Inscricao Inscricao = new Inscricao();
	private static Categoria cat;

	public void salvar()
	{
		if(cat.getInscricoes()==null)
			cat.setInscricoes(new ArrayList<Inscricao>());
		cat.getInscricoes().add(Inscricao);
		
		service.salvar(Inscricao);
		Inscricao = new Inscricao();
	}
	
	@SuppressWarnings("unchecked")
	public void editarInscricao(ActionEvent event)
	{
		ArrayList<Inscricao> lista = (ArrayList<Inscricao>)event.getComponent().getAttributes().get("inscricoes");
		cat = (Categoria)event.getComponent().getAttributes().get("categoria");
		if (lista!=null&&lista.size()>0)
			cat.setInscricoes(lista);
		
		else
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
		service.setInscricoes(incricoes);
	}
}
	