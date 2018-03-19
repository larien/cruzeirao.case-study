package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Grupo;

public class GrupoService {

	private ArrayList <Grupo> grupos = new ArrayList<Grupo>();
	
	public GrupoService()
	{

	}
	
	public void salvar(Grupo grupo)
	{
		grupos.add(grupo);
	}

	public void remove(Grupo grupo)
	{
		grupos.remove(grupo);
	}

	public List <Grupo> getGrupos()
	{
		return grupos;
	}
	
}
