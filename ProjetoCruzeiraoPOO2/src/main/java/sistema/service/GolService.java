package sistema.service;

import java.util.List;

import sistema.DAO.GolDAO;
import sistema.modelos.Gol;

public class GolService {

	private GolDAO dao = new GolDAO();
	
	public GolService()
	{

	}
	
	public void salvar(Gol gol)
	{
		gol = dao.save(gol);
		dao.closeEntityManager();
		
	}
	
	public void alterar(Gol gol)
	{
		dao.save(gol);
		dao.closeEntityManager();
	}

	public void remove(Gol gol)
	{
		gol = dao.getById(Gol.class, gol.getId());
		dao.remove(gol);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Gol> getGols()
	{
		List <Gol> list = dao.getAll(Gol.class);
		dao.closeEntityManager();
		return list;
	}
	
}
