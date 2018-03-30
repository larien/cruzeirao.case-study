package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Inscrito;

public class InscritoService {

	private ArrayList <Inscrito> inscritos = new ArrayList<Inscrito>();
	
	public InscritoService()
	{

	}
	
	public void salvar(Inscrito inscrito)
	{
		inscritos.add(inscrito);
	}

	public void remove(Inscrito inscrito)
	{
		inscritos.remove(inscrito);
	}

	public List <Inscrito> getInscritos()
	{
		return inscritos;
	}
	
}
