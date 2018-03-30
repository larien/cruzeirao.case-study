package sistema.beans;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SlideEndEvent;

import enumeration.EnumSexoTipo;
import sistema.modelos.Categoria;
import sistema.service.CategoriaService;

@ManagedBean(eager=true)
@ApplicationScoped
public class CategoriaMB {
	private static final Enumeration<EnumSexoTipo> Masculino = null;
	private static final Enumeration<EnumSexoTipo> Feminino = null;
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
	
	public int getMaxJogadores() {
        return this.categoria.getMaxJogadores();
    }
 
    public void maxJogadores(int maxJogadores) {
        this.categoria.setMaxJogadores(maxJogadores);
    }
    
//	public int getMaxTimes() {
//        return this.categoria.getMaxTimes();
//    }
 
    public void maxTimes(int maxTimes) {
        this.categoria.setMaxJogadores(maxTimes);
    }
    
//    public void setSexo(String sexo) {
//    	    if(sexo == "Masc") this.categoria.setSexo(Masculino);
//    	    else this.categoria.setSexo(Feminino);
//    }
    
    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
     
    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
}
	