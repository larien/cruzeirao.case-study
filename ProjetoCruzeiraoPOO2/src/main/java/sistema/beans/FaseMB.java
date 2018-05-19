package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import enumeration.EnumFaseFormato;
import sistema.modelos.Categoria;
import sistema.modelos.Fase;
import sistema.service.FaseService;

@ManagedBean(eager=true)
@ApplicationScoped
public class FaseMB {
	private FaseService service = new FaseService();
	private Fase Fase = new Fase();
	private static Categoria categoria;

	public void salvar()
	{
		service.salvar(Fase);
		Fase = new Fase();
	}
	
	public Fase getFase() {
		return Fase;
	}
	public void setFase(Fase Fase) {
		this.Fase = Fase;
	}
	public void remover (Fase Fase)
	{
		service.remove(Fase);
	}

	public List<Fase> getFases() {
		return service.getFases();
	}
	public void editarFase(ActionEvent event)
	{
		categoria = (Categoria)event.getComponent().getAttributes().get("categoria");

		if (categoria.getFases()==null)
			categoria.setFases(new ArrayList<Fase>());
		//service.setFases(categoria.getFases());
		Fase.setCategoria(categoria);
	}

	public EnumFaseFormato[] getTipoFase(){
        return EnumFaseFormato.values();
    }
}
	