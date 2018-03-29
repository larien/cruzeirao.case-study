package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Cadastro;

public class CadastroService {

	private ArrayList <Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public CadastroService()
	{

	}
	
	public void salvar(Cadastro cadastro)
	{
		cadastros.add(cadastro);
	}

	public void remove(Cadastro cadastro)
	{
		cadastros.remove(cadastro);
	}

	public List <Cadastro> getCadastros()
	{
		return cadastros;
	}
	
}
