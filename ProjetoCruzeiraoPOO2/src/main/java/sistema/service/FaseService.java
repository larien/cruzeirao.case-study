package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Fase;

public class FaseService {

	private List <Fase> fases = new ArrayList<Fase>();
	
	public FaseService()
	{

	}
	
	public void salvar(Fase fase)
	{
		fases.add(fase);
	}

	public void remove(Fase fase)
	{
		fases.remove(fase);
	}

	public List <Fase> getFases()
	{
		return fases;
	}

	public void setFases(List<Fase> list) {
		this.fases = list;
	}
	
}
