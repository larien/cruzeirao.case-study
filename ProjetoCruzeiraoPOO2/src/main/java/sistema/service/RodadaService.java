package sistema.service;

import java.util.List;

import sistema.DAO.RodadaDAO;
import sistema.modelos.Rodada;

public class RodadaService {

	private RodadaDAO dao = new RodadaDAO();
	
	public RodadaService()
	{

	}
	
	public void salvar(Rodada rodada)
	{
		rodada = dao.save(rodada);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Rodada rodada)
	{
		dao.save(rodada);
		dao.closeEntityManager();
	}

	public void remove(Rodada rodada)
	{
		rodada = dao.getById(Rodada.class, rodada.getId());
		dao.remove(rodada);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Rodada> getRodadas()
	{
		List <Rodada> list = dao.getAll(Rodada.class);
		dao.closeEntityManager();
		return list;
	}


}
