package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.PartidaFutebol;

public class PartidaFutebolService {

	private ArrayList <PartidaFutebol> partidasFutebol = new ArrayList<PartidaFutebol>();
	
	public PartidaFutebolService()
	{

	}
	
	public void salvar(PartidaFutebol partidaFutebol)
	{
		partidasFutebol.add(partidaFutebol);
	}

	public void remove(PartidaFutebol partidaFutebol)
	{
		partidasFutebol.remove(partidaFutebol);
	}

	public List <PartidaFutebol> getPartidasFutebol()
	{
		return partidasFutebol;
	}
	
}
