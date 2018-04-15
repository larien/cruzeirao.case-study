package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Usuario;

public class CadastroService {

	private ArrayList <Usuario> cadastros = new ArrayList<Usuario>();
	
	public CadastroService()
	{

	}
	
	public void salvar(Usuario cadastro)
	{
		cadastros.add(cadastro);
	}

	public void remove(Usuario cadastro)
	{
		cadastros.remove(cadastro);
	}

	public List <Usuario> getCadastros()
	{
		return cadastros;
	}
	
}
