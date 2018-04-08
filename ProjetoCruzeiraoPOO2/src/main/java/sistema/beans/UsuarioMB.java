package sistema.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import enumeration.EnumUsuarioTipo;
import sistema.modelos.Usuario;
import sistema.service.UsuarioService;

@ManagedBean(eager=true)
@ApplicationScoped
public class UsuarioMB {
	private UsuarioService service = new UsuarioService();
	private Usuario Cadastro = new Usuario();

	public void salvar()
	{
		service.salvar(Cadastro);
		Cadastro = new Usuario();
	}
	
	public Usuario getCadastro() {
		return Cadastro;
	}
	public void setCadastro(Usuario Cadastro) {
		this.Cadastro = Cadastro;
	}
	public void remover (Usuario Cadastro)
	{
		service.remove(Cadastro);
	}

	public List<Usuario> getCadastros() {
		return service.getUsuarios();
	}
	public EnumUsuarioTipo[] getTipoUsuario(){
        return EnumUsuarioTipo.values();
    }
}
	