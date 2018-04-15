package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Rodada;

public class RodadaService {

	private List <Rodada> rodadas = new ArrayList<Rodada>();
	
	public RodadaService()
	{

	}
	
	public void salvar(Rodada rodada)
	{
		rodadas.add(rodada);
	}

	public void remove(Rodada rodada)
	{
		rodadas.remove(rodada);
	}

	public List <Rodada> getRodadas()
	{
		return rodadas;
	}

	public void setRodadas(List<Rodada> list) {
		this.rodadas = list;
	}
	
}
