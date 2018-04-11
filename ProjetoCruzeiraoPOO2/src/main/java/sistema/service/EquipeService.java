package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Equipe;

public class EquipeService {

	private ArrayList <Equipe> equipes = new ArrayList<Equipe>();
	
	public EquipeService()
	{

	}
	
	public void salvar(Equipe equipe)
	{
		equipes.add(equipe);
	}

	public void remove(Equipe equipe)
	{
		equipes.remove(equipe);
	}

	public List <Equipe> getEquipes()
	{
		return equipes;
	}

	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}
