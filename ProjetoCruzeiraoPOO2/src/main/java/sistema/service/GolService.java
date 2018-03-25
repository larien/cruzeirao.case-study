package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Gol;

public class GolService {

	private ArrayList <Gol> gols = new ArrayList<Gol>();
	
	public GolService()
	{

	}
	
	public void salvar(Gol gol)
	{
		gols.add(gol);
	}

	public void remove(Gol gol)
	{
		gols.remove(gol);
	}

	public List <Gol> getGols()
	{
		return gols;
	}
	
}
