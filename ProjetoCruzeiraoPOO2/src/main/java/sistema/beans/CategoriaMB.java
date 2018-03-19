package sistema.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Categoria;
import sistema.service.CategoriaService;

@ManagedBean(eager=true)
@ApplicationScoped
public class CategoriaMB {
	private CategoriaService service = new CategoriaService();
	private Categoria categoria = new Categoria();


	@PostConstruct
    public void init() {
		service = new CategoriaService();
		categoria = new Categoria();
    }
	public void salvar()
	{
		service.salvar(categoria);
		categoria = new Categoria();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void remover (Categoria categoria)
	{
		service.remove(categoria);
	}

	public List<Categoria> getCategorias() {
		return service.getCategorias();
	}
}
	