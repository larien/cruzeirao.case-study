package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sistema.modelos.Usuario;
import sistema.service.UsuarioService;

@ManagedBean(eager=true)
@ApplicationScoped
public class UsuarioMB {
	private UsuarioService service = new UsuarioService();
	private Usuario Usuario = new Usuario();

	public void salvar()
	{
		service.salvar(Usuario);
		Usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return Usuario;
	}
	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}
	public void remover (Usuario Usuario)
	{
		service.remove(Usuario);
	}

	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}
}
	