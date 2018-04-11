package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Usuario;

public class UsuarioService {

	private ArrayList <Usuario> Usuarios = new ArrayList<Usuario>();
	
	public UsuarioService()
	{

	}
	
	public void salvar(Usuario Usuario)
	{
		Usuarios.add(Usuario);
	}

	public void remove(Usuario Usuario)
	{
		Usuarios.remove(Usuario);
	}

	public List <Usuario> getUsuarios()
	{
		return Usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuarios = usuarios;
	}
	
}
