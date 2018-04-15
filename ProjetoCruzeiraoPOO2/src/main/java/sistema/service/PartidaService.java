package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Partida;

public class PartidaService {

	private List <Partida> partidas = new ArrayList<Partida>();
	
	public PartidaService()
	{

	}
	
	public void salvar(Partida partida)
	{
		partidas.add(partida);
	}

	public void remove(Partida partida)
	{
		partidas.remove(partida);
	}

	public List <Partida> getPartidas()
	{
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

}
