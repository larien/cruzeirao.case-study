package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Juiz;

public class JuizService {

	private List <Juiz> juizes = new ArrayList<Juiz>();
	
	public JuizService()
	{

	}
	
	public void salvar(Juiz juiz)
	{
		juizes.add(juiz);
	}

	public void remove(Juiz juiz)
	{
		juizes.remove(juiz);
	}

	public List <Juiz> getJuizes()
	{
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
		
	}
	
}
